package ar.edu.unq.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static ar.edu.unq.model.builders.TransactionBuilder.aTransaction;
import static ar.edu.unq.model.builders.CryptoCurrencyBuilder.aCryto;
import static ar.edu.unq.model.builders.UserCryptoBuilder.aUserCrypto;
import static ar.edu.unq.model.builders.OptionBuilder.aOption;

import org.junit.jupiter.api.Test;
import ar.edu.unq.cryptop2p.model.Cryptocurrency;
import ar.edu.unq.cryptop2p.model.OptionCall;
import ar.edu.unq.cryptop2p.model.Transaction;


public class TransactionTest {
    
    @Test
    void ShouldHaveTheAddressOfTheOptionWhenIsInstanciated()
    {
        var address = "12345678";
        var user = aUserCrypto().withCryptoAddress(address).build();
        var option = aOption().withUser(user).builOptionCall();
        var transaction = aTransaction().withOption(option).build();

        assertEquals(address, transaction.getAddress());
    }

    @Test
    void ShouldConsultTheCryptoCurrency()
    {
        var crypto = aCryto().build();
        var option = aOption().withCryptocurrency(crypto).build();
        var transaction = aTransaction().withOption(option).build();

        assertEquals(crypto, transaction.getCryptoCurrency());
    }

    @Test
    void ShouldConsultTheNominalAmountOfCryptoCurrency()
    {
        var nominalAmountOfCryptoCurrency = 1;
        var option = aOption().withCryptoAmount(nominalAmountOfCryptoCurrency).build();
        var transaction = aTransaction().withOption(option).build();

        assertEquals(nominalAmountOfCryptoCurrency, transaction.getAmountOfCryptoCurrency());
    }

    @Test
    void ShouldConsultThePriceOfTheCryptoCurrency()
    {
        var price  = 3000;
        var crypto = aCryto().withPrice(price).build();
        var option = aOption().withCryptocurrency(crypto).build();
        var transaction = aTransaction().withOption(option).build();

        assertEquals(price, transaction.cryptoPrice());
    }

    @Test
    void ShouldConsultTheTransactionAmount()
    {
        var price = (double) 3000;
        var amountOfCrypto = 0.1f;
        var crypto = aCryto().withPrice(price).build();
        var option = aOption().withCryptocurrency(crypto).withCryptoAmount(amountOfCrypto).build();
        var transaction = aTransaction().withOption(option).build();

       assertEquals(price * amountOfCrypto, transaction.transactionAmount()); 
    }

    @Test
    void ShoudConsultTheNameOfTheUserOwnerOfTheOption()
    {
        var user = aUserCrypto().withName("Victor").withSurname("Hugo").build();
        var option = aOption().withUser(user).build();
        var transaction = aTransaction().withOption(option).build();

        assertEquals("Victor Hugo", transaction.nameOfTheOwnerOfTheOption());
    }

    @Test
    void ShoudConsultTheNameOfTheInteresedUserInTheOption()
    {
        var interesed = aUserCrypto().withName("Jean").withSurname("Valjean").build();
        var option = aOption().withUser(interesed).build(); 
        var transaction = aTransaction().withOption(option).build();

        assertEquals("Jean Valjean", transaction.nameOfTheOwnerOfTheOption());
    }
     
    @Test //Todo mostrar la las operaciones de quien hizo la publicacion
    void ShoudConsultTheNumberOfOperationOfTheOwnerOfTheOption()
    {
        var numberOfOperations = 3;
        var owner = aUserCrypto().withNumberOfOperation(numberOfOperations).build();
        var option = aOption().withUser(owner).build();
        var transaction = aTransaction().withOption(option).build();

        assertEquals(numberOfOperations, transaction.numberOfOperations());
    }

    //here! 
    @Test //Todo mostrar la reputacion de quien hizo la publicacion
    void ShoudConsultTheReputationOfTheOwnerOfTheOption()
    {
        var reputation = 97;
        var owner = aUserCrypto().withReputation(reputation).build();
        var option = aOption().withUser(owner).build();
        var transaction = aTransaction().withOption(option).build();

        assertEquals(reputation, transaction.reputation());
    }
 
    @Test
    void ShoudShowCryptoAddressWhenIsAOptionCall()
    {
        var cryptoAddress = "meme1234";
        var seller = aUserCrypto().withCryptoAddress(cryptoAddress).build();
        var optionCall = aOption().withUser(seller).builOptionCall();
        var transaction = aTransaction().withOption(optionCall).build();

        assertEquals(cryptoAddress, transaction.getAddress());
    }

    @Test
    void ShoudShowCvuWhenIsAOptionPut()
    {
        var cryptoAddress = "0123456789012345678911";
        var buyer = aUserCrypto().withCvu(cryptoAddress).build();
        var optionPut = aOption().withUser(buyer).builOptionPut();
        var transaction = aTransaction().withOption(optionPut).build();

        assertEquals(cryptoAddress, transaction.getAddress());
    }
    



}
