package ar.edu.unq.cryptop2p.service;

import static ar.edu.unq.cryptop2p.helpers.ActionType.*;
import static ar.edu.unq.cryptop2p.helpers.OptionType.*;
import static ar.edu.unq.cryptop2p.helpers.StateType.*;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.dto.OptionSelectDto;
import ar.edu.unq.cryptop2p.model.dto.TransactionProcessDto;
import ar.edu.unq.cryptop2p.model.dto.UserRegisterDto;
import ar.edu.unq.cryptop2p.model.exceptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static ar.edu.unq.cryptop2p.builders.CryptoCurrencyBuilder.aCryto;
import static ar.edu.unq.cryptop2p.builders.OptionConcreteBuilder.anyOption;
import static ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionServiceTest {

    @Autowired
    private UserCryptoService userService;


    @Autowired
    private CryptoCurrencyService cryptoService;


    @Autowired
    private OptionService optionService;

    @Autowired
    private TransactionService transactionService;


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }
/*
    @Test
    @DirtiesContext
    void create() throws PreconditionFailedException, NotFoundException, BadRequestException, ConfirmReceptionException, MakeTransferException, CancelException {

        UserCrypto aUser = aUserCrypto().withEmail("otronail@gmail.com")
                .withName("Pedro")
                .withSurname("Picapiedra")
                .withAddress("dir1132123123")
                .withPassword("Very_Secret!")
                .withCvu("1234567890123456789012")
                .withCryptoAddress("12345678")
                .build();



        UserCrypto aCounterParty = aUserCrypto().withEmail("Pablomail@gmail.com")
                .withName("Pablo")
                .withSurname("Marmol")
                .withAddress("dir1132121111")
                .withPassword("Extremly_Secret!")
                .withCvu("1234567890123456781111")
                .withCryptoAddress("12345555")
                .build();


        var user = userService.register(aUser);
        var counterParty = userService.register(aCounterParty);

        CryptoCurrency aCrypto = aCryto().withName("A").withPrice(10).build();
        var crypto =  cryptoService.create(aCrypto);

        var optionPut = anyOption().withPrice(9.7).withCryptoAmount(3).withCryptoCurrency(crypto) .withUser(user).build();
        var optioPostDto = new OptionPostDto( OPTIONPUT, crypto.getName(), optionPut.getPrice(), optionPut.getCryptoAmount(),user.getId());
        var  optionPutSaved = optionService.post(optioPostDto);
        var options = optionService.findAll();
        var transaction =  transactionService.create(optionPutSaved.getId(),counterParty.getId());
       var transactions = transactionService.findAll();
       var transactionData = new TransactionProcessDto(transaction.getId(), MAKETRANSFER);
       var transactionProcessed = transactionService.process(transactionData);

        assertFalse(options.isEmpty());
        assertFalse(transactions.isEmpty());
        assertEquals(CVUSENT, transactionProcessed.getStateType());
        assertEquals(MAKETRANSFER,transactionProcessed.getActionType());
        assertEquals(OPTIONPUT, transactionProcessed.getOperationType());
        assertEquals(9.7,transactionProcessed.getPrice());
        assertEquals(10,transactionProcessed.cryptoPrice());

        var transactionData2 = new TransactionProcessDto(transaction.getId(),MAKETRANSFER);

      assertThrows ( MakeTransferException.class , () -> transactionService.process(transactionData2));


        var transactionData3 = new TransactionProcessDto(transaction.getId(),CONFIRMRECEPTION);
        var transactionProcessed2 = transactionService.process(transactionData3);

        assertEquals(CRYPTOCURRENTSENT, transactionProcessed2.getStateType());
        assertEquals(CONFIRMRECEPTION,transactionProcessed2.getActionType());
        assertEquals(OPTIONPUT, transactionProcessed2.getOperationType());
        assertEquals(9.7,transactionProcessed2.getPrice());
        assertEquals(10,transactionProcessed2.cryptoPrice());
        assertEquals(1,transactionProcessed2.numberOfOperations());
        assertEquals(10,transactionProcessed2.scores());
        assertEquals(10,transactionProcessed2.reputation());


    }

*/
    @Test
    void select() throws PreconditionFailedException, NotFoundException, BadRequestException, ConfirmReceptionException, MakeTransferException, CancelException {

        UserCrypto aUser = aUserCrypto().withEmail("otronail@gmail.com")
                .withName("Pedro")
                .withSurname("Picapiedra")
                .withAddress("dir1132123123")
                .withPassword("Very_Secret!")
                .withCvu("1234567890123456789012")
                .withCryptoAddress("12345678")
                .build();



        UserCrypto aCounterParty = aUserCrypto().withEmail("Pablomail@gmail.com")
                .withName("Pablo")
                .withSurname("Marmol")
                .withAddress("dir1132121111")
                .withPassword("Extremly_Secret!")
                .withCvu("1234567890123456781111")
                .withCryptoAddress("12345555")
                .build();


        var user = userService.register(aUser);
        var counterParty = userService.register(aCounterParty);

        CryptoCurrency aCrypto = aCryto().withName("A").withPrice(10).build();
        var crypto =  cryptoService.create(aCrypto);

        var optionPut = anyOption().withPrice(9.7).withCryptoAmount(3).withCryptoCurrency(crypto) .withUser(user).build();
        var optioPostDto = new OptionPostDto( OPTIONPUT, crypto.getName(), optionPut.getPrice(), optionPut.getCryptoAmount(),user.getId());
        var  optionPutSaved = optionService.post(optioPostDto);
        var optionSelectDto =  new OptionSelectDto(optionPutSaved.getId(),counterParty.getId());

        var counterpartySaved = userService.select(optionSelectDto);

        var transaction = transactionService.acept(optionSelectDto);
        var transactions = transactionService.findAll();

        assertEquals("Pablo",counterpartySaved.getName());
        assertFalse(counterpartySaved.getOptioms().isEmpty());
        assertEquals(9.7,counterpartySaved.getOptioms().stream().findFirst().get().getPrice());
        assertFalse(transactions.isEmpty());
        }
    }
