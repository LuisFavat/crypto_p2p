/*
package ar.edu.unq.cryptop2p.service;

import static ar.edu.unq.cryptop2p.helpers.ActionType.*;
import static ar.edu.unq.cryptop2p.helpers.OptionType.*;
import static ar.edu.unq.cryptop2p.helpers.StateType.*;

import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.model.*;
import ar.edu.unq.cryptop2p.model.dto.*;
import ar.edu.unq.cryptop2p.model.exceptions.*;
import ar.edu.unq.cryptop2p.persistence.OptionRepository;
import ar.edu.unq.cryptop2p.persistence.TransactionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.annotation.DirtiesContext;

import java.text.ParseException;
import java.util.List;

import static ar.edu.unq.cryptop2p.builders.CryptoCurrencyBuilder.aCryto;
import static ar.edu.unq.cryptop2p.builders.OptionConcreteBuilder.anyOption;
import static ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
import static org.junit.jupiter.api.Assertions.*;
import static ar.edu.unq.cryptop2p.builders.TransactionBuilder.aTransaction;
import static ar.edu.unq.cryptop2p.helpers.CurrentDateTime.*;


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

    @Autowired
    private TransactionRepository transactionRepository;


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }
*/

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
//
//    @Test
//    void select() throws PreconditionFailedException, NotFoundException, BadRequestException, ConfirmReceptionException, MakeTransferException, CancelException {
//
//        UserCrypto aUser = aUserCrypto().withEmail("otronail@gmail.com")
//                .withName("Pedro")
//                .withSurname("Picapiedra")
//                .withAddress("dir1132123123")
//                .withPassword("Very_Secret!")
//                .withCvu("1234567890123456789012")
//                .withCryptoAddress("12345678")
//                .build();
//
//
//
//        UserCrypto aCounterParty = aUserCrypto().withEmail("Pablomail@gmail.com")
//                .withName("Pablo")
//                .withSurname("Marmol")
//                .withAddress("dir1132121111")
//                .withPassword("Extremly_Secret!")
//                .withCvu("1234567890123456781111")
//                .withCryptoAddress("12345555")
//                .build();
//
//
//        var user = userService.register(aUser);
//        var counterParty = userService.register(aCounterParty);
//
//        CryptoCurrency aCrypto = aCryto().withName("A").withPrice(10).build();
//        var crypto =  cryptoService.create(aCrypto);
//
//        var optionPut = anyOption().withPrice(9.7).withCryptoAmount(3).withCryptoCurrency(crypto) .withUser(user).build();
//        var optioPostDto = new OptionPostDto( OPTIONPUT, crypto.getName(), optionPut.getPrice(), optionPut.getCryptoAmount(),user.getId());
//        var  optionPutSaved = optionService.post(optioPostDto);
//        var transactionData =  new TransactionCreateDto(optionPutSaved.getId(),counterParty.getId());
//
//        var counterpartySaved = userService.select(transactionData);
//
//        var transaction = transactionService.acept(transactionData);
//        var transactions = transactionService.findAll();
//
//        assertEquals("Pablo",counterpartySaved.getName());
//        assertFalse(counterpartySaved.getOptioms().isEmpty());
//        assertEquals(9.7,counterpartySaved.getOptioms().stream().findFirst().get().getPrice());
//        assertFalse(transactions.isEmpty());
//        }

    /*
    @Test
    @DirtiesContext
    void options() throws PreconditionFailedException, NotFoundException, BadRequestException, ParseException {
        Option option1,option2,option3,option4,option5 ;
        Transaction t1,t2,t3,t4,t5;
        String startDate = "9/10/2023";
        String endDate = "12/11/2023";


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


        var optionPostDto = new OptionPostDto( OPTIONPUT, crypto.getName(), 9.7, 3,user.getId());
         option1 = optionService.post(optionPostDto);
         t1 = aTransaction().wwithOption(option1).withOperation(option1.getOperation())
                 .withCryptoCurrency(option1.getCryptocurrency())//.withUser(option1.getUser())
                 .withCounterPartyUser(counterParty).build();
         t1.setDateTime(stringToDate("10/10/2023"));
        var transaction1 = transactionRepository.save(t1);

        var optionPostDto2 = new OptionPostDto( OPTIONPUT, crypto2.getName(), 9.5, 7,user.getId());
       option2 = optionService.post(optionPostDto2);
        t2 =   aTransaction().wwithOption(option2).withOperation(option2.getOperation())
                .withCryptoCurrency(option2.getCryptocurrency())//.withUser(option2.getUser())
                .withCounterPartyUser(counterParty).build();
        t2.setDateTime(stringToDate("9/11/2023"));
        var transaction2 = transactionRepository.save(t2);


        var optionPostDto3= new OptionPostDto( OPTIONCALL, crypto.getName(), 9.8, 4,user.getId());
        option3 = optionService.post(optionPostDto3);
        t3 = aTransaction().wwithOption(option3).withOperation(option3.getOperation())
                .withCryptoCurrency(option3.getCryptocurrency())//.withUser(option3.getUser())
                .withCounterPartyUser(counterParty).build();
        t3.setDateTime(stringToDate("15/11/2023"));
        var transaction3 = transactionRepository.save(t3);


        var optionPostDto4= new OptionPostDto( OPTIONCALL, crypto.getName(), 9.9, 4,counterParty.getId());
       option4 = optionService.post(optionPostDto4);
        t4 =aTransaction().wwithOption(option4).withOperation(option4.getOperation())
                .withCryptoCurrency(option4.getCryptocurrency())//.withUser(option4.getUser())
                .withCounterPartyUser(user).build();
        t4.setDateTime(stringToDate("30/10/2023"));
        var transaction4 = transactionRepository.save(t4);


        var optionPostDto5= new OptionPostDto( OPTIONCALL, crypto.getName(), 9.9, 5,user.getId());
        option5 = optionService.post(optionPostDto5);
        t5 = aTransaction().wwithOption(option5).withOperation(option5.getOperation())
                .withCryptoCurrency(option5.getCryptocurrency())//.withUser(option5.getUser())
                .withCounterPartyUser(counterParty).build();
        t5.setDateTime(stringToDate("19/10/2023"));
        var transaction5 = transactionRepository.save(t5);


        var options = optionService.findAll();
        var transactions = transactionRepository.findAll();

        var volumeData = new TradedVoluolumeDto(startDate,endDate, user.getId()).convertStringToDate();

        var  tradedVolume = transactionService.tradeVolume(volumeData);

        assertEquals(5, options.size());
        assertEquals(5, transactions.size());
        assertFalse(options.isEmpty());
        assertFalse(transactions.isEmpty());
        assertFalse(tradedVolume.getCryptoCurrencyList().isEmpty());
        assertEquals(2, tradedVolume.getCryptoCurrencyList().size());

    }
*/
    /*
    @Test
    @DirtiesContext
    void cryptoQuotesLast24hs() throws PreconditionFailedException, NotFoundException {

        CryptoCurrency aCrypto = aCryto().withName("AUDIOUSDT").withPrice(10).build();
        var crypto =  cryptoService.create(aCrypto);


        CryptoCurrency aCrypto2 = aCryto().withName("ALICEUSDT").withPrice(10).build();
        var crypto2 =  cryptoService.create(aCrypto2);

        List<CryptoCurrencyLastQuoteDto> cryptoQuotes = cryptoService.getCryptoCurrencyLastQuotes24hs(crypto.getName());

        assertFalse(cryptoQuotes.isEmpty());
        assertEquals(24, cryptoQuotes.size());
        assertEquals(crypto.getName(), cryptoQuotes.stream().findAny().get().getName());


    }
}
*/