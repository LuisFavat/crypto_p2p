package ar.edu.unq.cryptop2p.service;


import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.TradeVolumeLocalDateDto;
import ar.edu.unq.cryptop2p.model.dto.TransactionCreateDto;
import ar.edu.unq.cryptop2p.model.dto.TransactionProcessDto;
import ar.edu.unq.cryptop2p.model.exceptions.*;
import ar.edu.unq.cryptop2p.persistence.TransactionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import static ar.edu.unq.cryptop2p.model.validators.Validator.response;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserCryptoService userService;

    @Autowired
    private OptionService optionService;



    @Transactional
    public Transaction acept(TransactionCreateDto transactiondata) throws NotFoundException, BadRequestException {
        var counterPartyUser = userService.findByID(transactiondata.getIdCounterParty());
        var option =    optionService.findByID(transactiondata.getIdOption());
        checkings(option,counterPartyUser);
        return  create(transactiondata.getIdOption(),transactiondata.getIdCounterParty());
    }


    public void checkings (Option option, UserCrypto counterPartyUser ) throws  BadRequestException {
        option.checkNotSameUser(counterPartyUser);
        option.checkSelectedByCounterParty(counterPartyUser);
    }



    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Transaction create(int id_Option,Long id_counterPartyUser) throws NotFoundException {
        Option option = optionService.findByID(id_Option);
         UserCrypto counterPartyUser = userService.findByID(id_counterPartyUser);
        Transaction transaction = new Transaction(option);
        transaction.setCounterPartyUser(counterPartyUser);
        Transaction transactionSaved = transactionRepository.save(transaction);
        return transactionSaved;
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Transaction process (TransactionProcessDto transactionData) throws ConfirmReceptionException, MakeTransferException, CancelException, BadRequestException, NotFoundException {
        Transaction transaction = provideTransaction(transactionData);
        transaction.checkValidAction();
       // checkNotSameUser(transaction, transactionData);
        transaction.checkValidPriceToPost();
        var transactionProcessed =  transaction.execute();
        return transactionRepository.save(transactionProcessed);
    }

    public Transaction provideTransaction(@NotNull TransactionProcessDto transactionData) throws NotFoundException {
    Transaction transaction = findByID(transactionData.getIdTransaction());
    transaction.setActionType(transactionData.getActionType());
    return transaction;
    }
/*
    public void checkNotSameUser (@NotNull Transaction transaction, @NotNull TransactionProcessDto transactionData) throws NotFoundException, BadRequestException {
        UserCrypto userCounterParty = userService.findByID(transactionData.getIdCounterParty());
        transaction.checkNotSameUser(userCounterParty);
     }
*/
    @Transactional
    public  List<Transaction> findAll() {
        return  transactionRepository.findAll();
    }

    @Transactional
    public Transaction findByID(int id) throws NotFoundException {
        var  transaction = transactionRepository.findById(id);
        if (transaction.isEmpty()) {
            String message = MessageFormat.format(" Transaction with Id: {0} not found.", id);
            response(message, HttpStatus.NOT_FOUND);
             throw new NotFoundException(message);
        }
        return transaction.get();

    }

    @Transactional
    @NotNull
    public List <Transaction> tradeVolume(TradeVolumeLocalDateDto volumeData) throws NotFoundException {
     var user =   userService.findByID(volumeData.getUserId());
    var transactions =   transactionRepository.findTransactionByUserAndDateTimeBetweenOrderByAmountOfCryptoCurrencyAsc (user,volumeData.getStartDate(),volumeData.getEndDate());
        if (transactions.isEmpty()) {
            String message = "There is not transactions for that search";
            response(message, HttpStatus.NOT_FOUND);
            throw new NotFoundException(message);
        }
        return transactions.get();
    }


}
