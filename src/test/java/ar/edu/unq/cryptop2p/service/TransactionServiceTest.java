package ar.edu.unq.cryptop2p.service;

import static ar.edu.unq.cryptop2p.helpers.ActionType.*;
import static ar.edu.unq.cryptop2p.helpers.OptionType.*;
import static ar.edu.unq.cryptop2p.helpers.StateType.*;

import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.model.*;
import ar.edu.unq.cryptop2p.model.dto.*;
import ar.edu.unq.cryptop2p.model.exceptions.*;
import ar.edu.unq.cryptop2p.persistence.OptionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.annotation.DirtiesContext;

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
    private OptionRepository optionRepository;


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
    /*
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
        var transactionData =  new TransactionCreateDto(optionPutSaved.getId(),counterParty.getId());

        var counterpartySaved = userService.select(transactionData);

        var transaction = transactionService.acept(transactionData);
        var transactions = transactionService.findAll();

        assertEquals("Pablo",counterpartySaved.getName());
        assertFalse(counterpartySaved.getOptioms().isEmpty());
        assertEquals(9.7,counterpartySaved.getOptioms().stream().findFirst().get().getPrice());
        assertFalse(transactions.isEmpty());
        }
*/
    @Test
    @DirtiesContext
    void options() throws PreconditionFailedException, NotFoundException, BadRequestException {
        Option option1,option2,option3 ;

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


        CryptoCurrency aCrypto2 = aCryto().withName("B").withPrice(10).build();
        var crypto2 =  cryptoService.create(aCrypto2);

        var optionPut = anyOption().withPrice(9.7).withCryptoAmount(3).withCryptoCurrency(crypto) .withUser(user).buildOptionPut();
        var optionPostDto = new OptionPostDto( OPTIONPUT, crypto.getName(), optionPut.getPrice(), optionPut.getCryptoAmount(),optionPut.getUser().getId());
        var  optionPutSaved1 = optionService.post(optionPostDto);

        var optionPut2 = anyOption().withPrice(9.5).withCryptoAmount(7).withCryptoCurrency(crypto) .withUser(user).buildOptionPut();
        var optionPostDto2 = new OptionPostDto( OPTIONPUT, crypto.getName(), optionPut2.getPrice(), optionPut2.getCryptoAmount(),optionPut2.getUser().getId());
        var  optionPutSaved2 = optionService.post(optionPostDto2);

        var optionPut3 = anyOption().withPrice(9.9).withCryptoAmount(4).withCryptoCurrency(crypto) .withUser(user).buildOptionCall();
        var optionPostDto3= new OptionPostDto( OPTIONCALL, crypto.getName(), optionPut3.getPrice(), optionPut3.getCryptoAmount(),optionPut3.getUser().getId());
        var  optionPutSaved3 = optionService.post(optionPostDto3);


        var options = optionService.findAll();

        assertEquals(3, options.size());
        assertFalse(options.isEmpty());
    }

    }
