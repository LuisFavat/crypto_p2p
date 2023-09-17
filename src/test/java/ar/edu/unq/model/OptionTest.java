package ar.edu.unq.model;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static ar.edu.unq.cryptop2p.builders.OptionConcreteBuilder.anyOption;
import static ar.edu.unq.cryptop2p.builders.CryptoCurrencyBuilder.aCryto;
import static org.junit.jupiter.api.Assertions.*;

class OptionTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void ItShouldBeSameOptionPriceWhenSettingPrice() {

        var option = anyOption().withPrice(5.00).build();

        assertEquals(5.00, option.getPrice());
    }

    @Test
    void ItShouldBeSameCryptoAmountWhenSettingUnits(){

        var option = anyOption().withCryptoAmount(2).build();

        assertEquals(2, option.getCryptoAmount());
    }

    @Test
    void ItShouldBeExpect10WhenGetTheAmountPriceInPesos() {
        var option = anyOption().withPrice(5.00).withCryptoAmount(2).build();

        assertEquals(10.00, option.amountPriceInPesos());
    }

    @Test
    void ItShouldBeTrueWhenOptionPriceHigherOrEqualThanfivePercentDown() {
        var crypto = aCryto().withPrice(10).build();
        var option = anyOption().withCryptoCurrency(crypto).withPrice(15).build();
        assertTrue ( option.optionPriceHigherOrEqualThanfivePercentDown());
    }

    @Test
    void ItShouldBeFalseWhenOptionPriceHigherOrEqualThanfivePercentDown() {
        var crypto = aCryto().withPrice(10).build();
        var option = anyOption().withCryptoCurrency(crypto).withPrice(9).build();

        assertFalse ( option.optionPriceHigherOrEqualThanfivePercentDown());
    }

    @Test
    void ItShouldBeTrueWhenOOptionPriceLowerOrEqualThanPercentUp() {
        var crypto = aCryto().withPrice(10).build();
        var option = anyOption().withCryptoCurrency(crypto).withPrice(9).build();
        assertTrue ( option.optionPriceLowerOrEqualThanPercentUp());
    }

    @Test
    void ItShouldBeFalseWhenOOptionPriceLowerOrEqualThanPercentUp() {
        var crypto = aCryto().withPrice(10).build();
        var option = anyOption().withCryptoCurrency(crypto).withPrice(15).build();

        assertFalse ( option.optionPriceLowerOrEqualThanPercentUp());
    }

    @Test
    void ItShouldBeTrueWhenValidateOptionPriceInARangeOfFiveUpAndDown() {
        var crypto=  aCryto().withPrice(10).build();
        var option = anyOption().withCryptoCurrency(crypto).withPrice(10).build();

        assertTrue( option.validateOptionPriceInARangeOfFiveUpAndDown());
    }


    @Test
    void ItShouldBefalseWhenValidateOptionPriceInARangeOfFiveUpAndDown() {
        var crypto=  aCryto().withPrice(10).build();
        var option = anyOption().withCryptoCurrency(crypto).withPrice(9).build();

        assertFalse( option.validateOptionPriceInARangeOfFiveUpAndDown());
    }


    @Test
    void ItShouldBeTrueWhenOptionCallIsValidPriceToPost() {
      var crypto = aCryto().withPrice(5).build();
      var option = anyOption().withCryptoCurrency(crypto).withPrice(10).buildOptionCall();
       assertTrue ( option.IsValidPriceToPost());
    }

    @Test
     void ItShouldBeFalseWhenOptionCallIsValidPriceToPost() {
        var crypto = aCryto().withPrice(10).build();
        var option = anyOption().withCryptoCurrency(crypto).withPrice(5).buildOptionCall();
        assertFalse ( option.IsValidPriceToPost() );
    }


    @Test
    void ItShouldBeTrueWhenOptionPutIsValidPriceToPost() {
        var crypto = aCryto().withPrice(10).build();
        var option = anyOption().withCryptoCurrency(crypto).withPrice(5).buildOptionPut();
        assertTrue ( option.IsValidPriceToPost());
    }

    @Test
    void ItShouldBeFalseWhenOptionPutIsValidPriceToPost() {
        var crypto = aCryto().withPrice(5).build();
        var option = anyOption().withCryptoCurrency(crypto).withPrice(10).buildOptionPut();
        assertFalse ( option.IsValidPriceToPost() );
    }



    @AfterEach
    void tearDown() {
    }
}