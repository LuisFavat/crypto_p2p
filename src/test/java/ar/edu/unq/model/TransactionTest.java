package ar.edu.unq.model;


//import static ar.edu.unq.cryptop2p.builders.TransactionBuilder.aTransaction;
//import static ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
//import static ar.edu.unq.cryptop2p.builders.CryptoCurrencyBuilder.aCryto;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;



public class TransactionTest {
    
    @Test
    void ShouldHaveTheAddressOfTheOptionWhenIsInstanciated()
    {
        var address = "12345678";
        //var transaction = aTransaction().withAddress(address).build();

      //  assertEquals(address, transaction.getAddress());
    }

    @Test
    void ShouldConsultTheCryptoCurrency()
    {
        //var crypto = aCryto().build();
        //var transaction = aTransaction().withCryptoCurrency(crypto).build();

        //assertEquals(crypto, transaction.getCryptoCurrency());
    }

    @Test
    void ShouldConsultTheNominalAmountOfCryptoCurrency()
    {
        var nominalAmountOfCryptoCurrency = 1;
       // var transaction = aTransaction().withAmountOfCryptoCurrency(nominalAmountOfCryptoCurrency).build();

       // assertEquals(nominalAmountOfCryptoCurrency, transaction.getAmountOfCryptoCurrency());
    }

    @Test
    void ShouldConsultThePriceOfTheCryptoCurrency()
    {
        var price  = 3000;
       // var crypto = aCryto().withPrice(price).build();
       // var transaction = aTransaction().withCryptoCurrency(crypto).build();

      //  assertEquals(price, transaction.cryptoPrice());
    }

    @Test
    void ShouldConsultTheTransactionAmount()
    {
        var price = (double) 3000;
        var amountOfCrypto = 0.1f;
       // var crypto = aCryto().withPrice(price).build();
       // var transaction = aTransaction().withCryptoCurrency(crypto).withAmountOfCryptoCurrency(amountOfCrypto).build();

      //  assertEquals(price * amountOfCrypto, transaction.transactionAmount());
    }

    @Test
    void ShoudConsultTheNameOfTheBuyer()
    {
      //  var buyer = aUserCrypto().withName("Victor").withSurname("Hugo").build();
      //  var transaction = aTransaction().withBuyer(buyer).build();

       // assertEquals("Victor Hugo", transaction.buyerName());
    }

    @Test
    void ShoudConsultTheNameOfTheSeller()
    {
      //  var seller = aUserCrypto().withName("Jean").withSurname("Valjean").build();
       // var transaction = aTransaction().withBuyer(seller).build();

      //  assertEquals("Jean Valjean", transaction.buyerName());
    }
     
    @Test
    void ShoudConsultTheNumberOfOperationOfTheSeller()
    {
        var numberOfOperations = 3;
       // var seller = aUserCrypto().withNumberOfOperation(numberOfOperations).build();
       // var transaction = aTransaction().withSeller(seller).build();

       // assertEquals(numberOfOperations, transaction.numberOfOperations());
    }

    @Test
    void ShoudConsultTheSellerReputation()
    {
        var reputation = 97;
       // var seller = aUserCrypto().withReputation(reputation).build();
       // var transaction = aTransaction().withSeller(seller).build();

       // transaction.setSellerReputation();

       // assertEquals(reputation, transaction.getSellerReputation());
    }
    



}
