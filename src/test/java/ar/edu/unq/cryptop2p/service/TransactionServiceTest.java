package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.dto.UserRegisterDto;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static ar.edu.unq.cryptop2p.builders.CryptoCurrencyBuilder.aCryto;
import static ar.edu.unq.cryptop2p.builders.OptionConcreteBuilder.anyOption;
import static ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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

    @Test
    void create() throws PreconditionFailedException, NotFoundException, BadRequestException {

        UserCrypto aUser = aUserCrypto().withEmail("otronail@gmail.com")
                .withName("Pedro")
                .withSurname("Picapiedra")
                .withAddress("dir1132123123")
                .withPassword("Very_Secret!")
                .withCvu("1234567890123456789012")
                .withCryptoAddress("12345678")
                .build();
        CryptoCurrency aCrypto = aCryto().withName("A").withPrice(10).build();

        var user = userService.register(aUser);
        var crypto =  cryptoService.create(aCrypto);

        var optionPut = anyOption().withPrice(9.7).withCryptoAmount(3).withCryptoCurrency(crypto) .withUser(user).build();
        var optioPostDto = new OptionPostDto( OptionType.OPTIONPUT, crypto.getName(), optionPut.getPrice(), optionPut.getCryptoAmount(),user.getId());
        var  optionPutSaved = optionService.post(optioPostDto);
        var options = optionService.findAll();
        var transaction =  transactionService.create(optionPutSaved.getId());
       var transactions = transactionService.findAll();

        assertFalse(options.isEmpty());
        assertFalse(transactions.isEmpty());

    }
    }
