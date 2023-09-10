package ar.edu.unq.model;


<<<<<<< HEAD
//import static ar.edu.unq.cryptop2p.builders.TransactionBuilder.aTransaction;
//import static ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
//import static ar.edu.unq.cryptop2p.builders.CryptoCurrencyBuilder.aCryto;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ar.edu.unq.model.builders.TransactionBuilder.aTransaction;
import static ar.edu.unq.model.builders.CryptoCurrencyBuilder.aCryto;
import static ar.edu.unq.model.builders.UserCryptoBuilder.aUserCrypto;
import static ar.edu.unq.model.builders.OptionBuilder.aOption;

>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733
import org.junit.jupiter.api.Test;
import ar.edu.unq.cryptop2p.model.Cryptocurrency;
import ar.edu.unq.cryptop2p.model.OptionCall;
import ar.edu.unq.cryptop2p.model.Transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class TransactionTest {
    
    @Test
    void ShouldHaveTheAddressOfTheOptionWhenIsInstanciated()
    {
        var address = "12345678";
<<<<<<< HEAD
        //var transaction = aTransaction().withAddress(address).build();
=======
        var user = aUserCrypto().withCryptoAddress(address).build();
        var option = aOption().withUser(user).builOptionCall();
        var transaction = aTransaction().withOption(option).build();
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733

      //  assertEquals(address, transaction.getAddress());
    }

    @Test
    void ShouldConsultTheCryptoCurrency()
    {
<<<<<<< HEAD
        //var crypto = aCryto().build();
        //var transaction = aTransaction().withCryptoCurrency(crypto).build();
=======
        var crypto = aCryto().build();
        var option = aOption().withCryptocurrency(crypto).build();
        var transaction = aTransaction().withOption(option).build();
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733

        //assertEquals(crypto, transaction.getCryptoCurrency());
    }

    @Test
    void ShouldConsultTheNominalAmountOfCryptoCurrency()
    {
        var nominalAmountOfCryptoCurrency = 1;
<<<<<<< HEAD
       // var transaction = aTransaction().withAmountOfCryptoCurrency(nominalAmountOfCryptoCurrency).build();
=======
        var option = aOption().withCryptoAmount(nominalAmountOfCryptoCurrency).build();
        var transaction = aTransaction().withOption(option).build();
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733

       // assertEquals(nominalAmountOfCryptoCurrency, transaction.getAmountOfCryptoCurrency());
    }

    @Test
    void ShouldConsultThePriceOfTheCryptoCurrency()
    {
        var price  = 3000;
<<<<<<< HEAD
       // var crypto = aCryto().withPrice(price).build();
       // var transaction = aTransaction().withCryptoCurrency(crypto).build();
=======
        var crypto = aCryto().withPrice(price).build();
        var option = aOption().withCryptocurrency(crypto).build();
        var transaction = aTransaction().withOption(option).build();
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733

      //  assertEquals(price, transaction.cryptoPrice());
    }

    @Test
    void ShouldConsultTheTransactionAmount()
    {
        var price = (double) 3000;
        var amountOfCrypto = 0.1f;
<<<<<<< HEAD
       // var crypto = aCryto().withPrice(price).build();
       // var transaction = aTransaction().withCryptoCurrency(crypto).withAmountOfCryptoCurrency(amountOfCrypto).build();

      //  assertEquals(price * amountOfCrypto, transaction.transactionAmount());
=======
        var crypto = aCryto().withPrice(price).build();
        var option = aOption().withCryptocurrency(crypto).withCryptoAmount(amountOfCrypto).build();
        var transaction = aTransaction().withOption(option).build();

       assertEquals(price * amountOfCrypto, transaction.transactionAmount()); 
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733
    }

    @Test
    void ShoudConsultTheNameOfTheUserOwnerOfTheOption()
    {
<<<<<<< HEAD
      //  var buyer = aUserCrypto().withName("Victor").withSurname("Hugo").build();
      //  var transaction = aTransaction().withBuyer(buyer).build();

       // assertEquals("Victor Hugo", transaction.buyerName());
=======
        var user = aUserCrypto().withName("Victor").withSurname("Hugo").build();
        var option = aOption().withUser(user).build();
        var transaction = aTransaction().withOption(option).build();

        assertEquals("Victor Hugo", transaction.nameOfTheOwnerOfTheOption());
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733
    }

    @Test
    void ShoudConsultTheNameOfTheInteresedUserInTheOption()
    {
<<<<<<< HEAD
      //  var seller = aUserCrypto().withName("Jean").withSurname("Valjean").build();
       // var transaction = aTransaction().withBuyer(seller).build();

      //  assertEquals("Jean Valjean", transaction.buyerName());
=======
        var interesed = aUserCrypto().withName("Jean").withSurname("Valjean").build();
        var option = aOption().withUser(interesed).build(); 
        var transaction = aTransaction().withOption(option).build();

        assertEquals("Jean Valjean", transaction.nameOfTheOwnerOfTheOption());
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733
    }
     
    @Test //Todo mostrar la las operaciones de quien hizo la publicacion
    void ShoudConsultTheNumberOfOperationOfTheOwnerOfTheOption()
    {
        var numberOfOperations = 3;
<<<<<<< HEAD
       // var seller = aUserCrypto().withNumberOfOperation(numberOfOperations).build();
       // var transaction = aTransaction().withSeller(seller).build();
=======
        var owner = aUserCrypto().withNumberOfOperation(numberOfOperations).build();
        var option = aOption().withUser(owner).build();
        var transaction = aTransaction().withOption(option).build();
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733

       // assertEquals(numberOfOperations, transaction.numberOfOperations());
    }

    //here! 
    @Test //Todo mostrar la reputacion de quien hizo la publicacion
    void ShoudConsultTheReputationOfTheOwnerOfTheOption()
    {
        var reputation = 97;
<<<<<<< HEAD
       // var seller = aUserCrypto().withReputation(reputation).build();
       // var transaction = aTransaction().withSeller(seller).build();

       // transaction.setSellerReputation();

       // assertEquals(reputation, transaction.getSellerReputation());
=======
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
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733
    }
    



}
