package ar.edu.unq.model;


import static ar.edu.unq.cryptop2p.builders.TransactionBuilder.aTransaction;
import static ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
import static ar.edu.unq.cryptop2p.builders.CryptoCurrencyBuilder.aCryto;
import static ar.edu.unq.cryptop2p.builders.OptionConcreteBuilder.anyOption;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ar.edu.unq.cryptop2p.helpers.ActionType.*;
import ar.edu.unq.cryptop2p.model.*;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.junit.jupiter.api.Test;


public class TransactionTest {
    
    @Test //TODO Arreglar este test esta mal
    void ShouldHaveTheAddressOfTheOptionWhenIsInstanciated() throws Exception {
        var address = "Rivadavia 1001";
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
    void ShoudConsultTheNameOfTheUserOwnerOfTheOption() throws Exception {


        var user = aUserCrypto().withName("Victor").withSurname("Hugo").build();
        var option = anyOption().withUser(user).build();
        var transaction = aTransaction().wwithOption(option).build();

        assertEquals("Victor Hugo", transaction.nameOfTheOwnerOfTheOption());

    }

    @Test
    void ShoudConsultTheNameOfTheInteresedUserInTheOption() throws Exception {

        var interesed = aUserCrypto().withName("Jean").withSurname("Valjean").build();
        var option = anyOption().withUser(interesed).build();
        var transaction = aTransaction().wwithOption(option).build();

        assertEquals("Jean Valjean", transaction.nameOfTheOwnerOfTheOption());

    }
     
    @Test
    void ShoudConsultTheNumberOfOperationOfTheOwnerOfTheOption() throws Exception {
        var numberOfOperations = 3;

        var owner = aUserCrypto().withNumberOfOperation(numberOfOperations).build();
        var option = anyOption().withUser(owner).build();
        var transaction = aTransaction().wwithOption(option).build();

       assertEquals(numberOfOperations, transaction.numberOfOperations());
    }

    //here! 
    @Test
    void ShoudConsultTheReputationOfTheOwnerOfTheOption() throws Exception {
        var reputation = 97;
        var owner = aUserCrypto().withScores(reputation).withNumberOfOperation(1).build();
        var option = anyOption().withUser(owner).build();
        var transaction = aTransaction().wwithOption(option).build();

        assertEquals(reputation, transaction.reputation());
    }
 
    @Test
    void ShoudShowCryptoAddressWhenIsAOptionCall() throws Exception {
        var cryptoAddress = "meme1234";
        var seller = aUserCrypto().withCryptoAddress(cryptoAddress).build();
        var optionCall = anyOption().withUser(seller).buildOptionCall();
        var transaction = aTransaction().wwithOption(optionCall).build();

        assertEquals(cryptoAddress, transaction.getAddress());
    }

    @Test
    void ShoudShowCvuWhenIsAOptionPut() throws Exception {
        var cryptoAddress = "0123456789012345678911";
        var buyer = aUserCrypto().withCvu(cryptoAddress).build();
        var optionPut = anyOption().withUser(buyer).buildOptionPut();
        var transaction = aTransaction().wwithOption(optionPut).build();

        assertEquals(cryptoAddress, transaction.getAddress());

    }

    @Test
    void TransactionShouldBeCVUSentStateWhenExecutingMakeTransferActionWithIdleStateByDefault() throws Exception {

        var seller = aUserCrypto().build();
        var transaction = aTransaction().withSeller(seller).withActionType(MAKETRANSFER).build();

        transaction.execute();;

        assertTrue(transaction.isCVUSent());

    }

    @Test
    void TransactionShouldBeCanceledWhenExecutingCancelActionAndIdleStateByDefault() throws Exception {

        var seller = aUserCrypto().build();
        var optionPut = anyOption().withUser(seller).buildOptionPut();
        var transaction = aTransaction().wwithOption(optionPut).withActionType(CANCEL).build();

        transaction.execute();

        assertTrue(transaction.isCanceled());

    }

    @Test
    void TransactionShouldBeCanceledWhenExecutingMakeTransferActionWithCanceledState() throws Exception {

        var seller = aUserCrypto().build();

        var transaction = aTransaction().withSeller(seller).withState(new Cancelled()).withActionType(MAKETRANSFER).build();

        transaction.execute();;

        assertTrue(transaction.isCanceled());

    }


    @Test
    void TransactionShouldThrowsMakeTransferExceptionWhenExecutingMakeTransferActionWithCVUSentState() throws Exception {

        var seller = aUserCrypto().build();

        var transaction = aTransaction().withSeller(seller).withState(new CVUSent()).withActionType(MAKETRANSFER).build();

        assertThrows ( MakeTransferException.class , transaction::execute);

    }


    @Test
    void TransactionShouldThrowsConfirmExceptionWhenExecutingConfirmReceptionActionWithIdleState() throws Exception {

        var seller = aUserCrypto().build();
        var buyer =  aUserCrypto().build();
        var optionPut = anyOption().withUser(seller).buildOptionPut();
        var transaction = aTransaction()
                .wwithOption(optionPut)
                .withCounterPartyUser(buyer)
                .withActionType(CONFIRMRECEPTION).build();

        assertThrows ( ConfirmReceptionException.class , transaction::execute);

    }



    @Test
    void cancel() throws Exception {
        var seller = aUserCrypto().withScores(100).withNumberOfOperation(1).build();
        var optionPut = anyOption().withUser(seller).buildOptionPut();
        var transaction = aTransaction().wwithOption(optionPut).build();

        transaction.cancel();

      assertEquals(80, transaction.reputation());
      assertTrue(transaction.isCanceled());
    }

    @Test
    void makeTransfer() {
    }

    @Test
    void confirmReception() {
    }


}
