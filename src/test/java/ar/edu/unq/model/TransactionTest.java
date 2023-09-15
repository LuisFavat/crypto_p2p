package ar.edu.unq.model;


import static ar.edu.unq.cryptop2p.builders.TransactionBuilder.aTransaction;
import static ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
import static ar.edu.unq.cryptop2p.builders.CryptoCurrencyBuilder.aCryto;
import static ar.edu.unq.cryptop2p.builders.OptionConcreteBuilder.anyOption;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class TransactionTest {
    
    @Test
    void ShouldHaveTheAddressOfTheOptionWhenIsInstanciated()
    {
        var address = "12345678";
        var user = aUserCrypto().withAddress(address).build();
        var  option = anyOption().withUser(user).build();
        var transaction = aTransaction().wwithOption(option).build();
        assertEquals(address, transaction.address());
    }

    @Test
    void ShouldConsultTheCryptoCurrency()
    {
        var crypto = aCryto().build();
        var option = anyOption().withCryptoCurrency(crypto).build();
        var transaction = aTransaction().wwithOption(option).build();

       assertEquals(crypto, transaction.getCryptoCurrency());
    }

    @Test
    void ShouldConsultTheNominalAmountOfCryptoCurrency()
    {
        var nominalAmountOfCryptoCurrency = 1;

       var option = anyOption().withCryptoAmount(nominalAmountOfCryptoCurrency).build();
       var transaction = aTransaction().wwithOption(option).build();

        assertEquals(nominalAmountOfCryptoCurrency, transaction.getAmountOfCryptoCurrency());
    }

    @Test
    void ShouldConsultThePriceOfTheCryptoCurrency()
    {
        var price  = 3000;

        var crypto = aCryto().withPrice(price).build();
        var option = anyOption().withCryptoCurrency(crypto).build();
        var transaction = aTransaction().wwithOption(option).build();

        assertEquals(price, transaction.cryptoPrice());
    }

    @Test
    void ShouldConsultTheTransactionAmount()
    {
        var price = (double) 3000;
        var amountOfCrypto = 0.1f;

        var crypto = aCryto().withPrice(price).build();
        var option = anyOption().withCryptoCurrency(crypto).withCryptoAmount(amountOfCrypto).build();
        var transaction = aTransaction().wwithOption(option).build();

       assertEquals(price * amountOfCrypto, transaction.transactionAmount()); 

    }

    @Test
    void ShoudConsultTheNameOfTheUserOwnerOfTheOption()
    {


        var user = aUserCrypto().withName("Victor").withSurname("Hugo").build();
        var option = anyOption().withUser(user).build();
        var transaction = aTransaction().wwithOption(option).build();

        assertEquals("Victor Hugo", transaction.nameOfTheOwnerOfTheOption());

    }

    @Test
    void ShoudConsultTheNameOfTheInteresedUserInTheOption()
    {

        var interesed = aUserCrypto().withName("Jean").withSurname("Valjean").build();
        var option = anyOption().withUser(interesed).build();
        var transaction = aTransaction().wwithOption(option).build();

        assertEquals("Jean Valjean", transaction.nameOfTheOwnerOfTheOption());

    }
     
    @Test //Todo mostrar la las operaciones de quien hizo la publicacion
    void ShoudConsultTheNumberOfOperationOfTheOwnerOfTheOption()
    {
        var numberOfOperations = 3;

        var owner = aUserCrypto().withNumberOfOperation(numberOfOperations).build();
        var option = anyOption().withUser(owner).build();
        var transaction = aTransaction().wwithOption(option).build();

       assertEquals(numberOfOperations, transaction.numberOfOperations());
    }

    //here! 
    @Test //Todo mostrar la reputacion de quien hizo la publicacion
    void ShoudConsultTheReputationOfTheOwnerOfTheOption()
    {
        var reputation = 97;
        var owner = aUserCrypto().withReputation(reputation).build();
        var option = anyOption().withUser(owner).build();
        var transaction = aTransaction().wwithOption(option).build();

        assertEquals(reputation, transaction.reputation());
    }
 
    @Test
    void ShoudShowCryptoAddressWhenIsAOptionCall()
    {
        var cryptoAddress = "meme1234";
        var seller = aUserCrypto().withCryptoAddress(cryptoAddress).build();
        var optionCall = anyOption().withUser(seller).buildOptionCall();
        var transaction = aTransaction().wwithOption(optionCall).build();

        assertEquals(cryptoAddress, transaction.getAddress());
    }

    @Test
    void ShoudShowCvuWhenIsAOptionPut()
    {
        var cryptoAddress = "0123456789012345678911";
        var buyer = aUserCrypto().withCvu(cryptoAddress).build();
        var optionPut = anyOption().withUser(buyer).buildOptionPut();
        var transaction = aTransaction().wwithOption(optionPut).build();

        assertEquals(cryptoAddress, transaction.getAddress());

    }

}