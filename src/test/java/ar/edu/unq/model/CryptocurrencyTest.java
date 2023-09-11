package ar.edu.unq.model;

import org.junit.jupiter.api.Test;

import static ar.edu.unq.cryptop2p.builders.CryptoCurrencyBuilder.aCryto;
import static org.junit.jupiter.api.Assertions.*;

class CryptocurrencyTest {

    @Test
    void ItShouldBeGetTheNameWhenIsInstanciated() {
        var crypto=  aCryto().withName("BSDT").build();

        assertEquals("BSDT", crypto.getName());
    }


    @Test
    void ItShouldBeGetThePriceWhenIsInstanciated() {
        var crypto=  aCryto().withPrice(1).build();

        assertEquals(1, crypto.getPrice());
    }

    @Test
    void ItShouldBeGetPercentDownWhenIsInstanciated() {
        var crypto=  aCryto().build();
        var  percentDown = 0.95;
        assertEquals(percentDown, crypto.getPercentDown());
    }

    @Test
    void ItShouldBeGetPercentUpWhenIsInstanciated() {
        var crypto=  aCryto().build();
        var  percentUp= 1.05;
        assertEquals(percentUp, crypto.getPercentUp());
    }



    @Test
    void tShouldBeGetThefivePercentDownWhenIsInstanciated(){
        var crypto=  aCryto().withPrice(10).build();

        assertEquals(10 * 0.95, crypto.fivePercentDown());
    }

    @Test
    void tShouldBeGetThefivePercentUpWhenIsInstanciated(){
        var crypto=  aCryto().withPrice(10).build();

        assertEquals(10 * 1.05, crypto.fivePercentUp());
    }


    @Test
     void ItShouldBeTrueWhenOptionPriceHigherOrEqualThanfivePercentDown() {
        var crypto = aCryto().withPrice(10).build();
        var optionPrice = 15;
        assertTrue ( crypto.OptionPriceHigherOrEqualThanfivePercentDown(optionPrice));
    }

    @Test
    void ItShouldBeFalseWhenOptionPriceHigherOrEqualThanfivePercentDown() {
        var crypto = aCryto().withPrice(10).build();
        var optionPrice = 9;
       assertFalse ( crypto.OptionPriceHigherOrEqualThanfivePercentDown(optionPrice));
    }

    @Test
    void ItShouldBeTrueWhenOOptionPriceLowerOrEqualThanPercentUp() {
        var crypto = aCryto().withPrice(10).build();
        var optionPrice = 9;
        assertTrue ( crypto.OptionPriceLowerOrEqualThanPercentUp(optionPrice));
    }

    @Test
    void ItShouldBeFalseWhenOOptionPriceLowerOrEqualThanPercentUp() {
        var crypto = aCryto().withPrice(10).build();
        var optionPrice = 15;
        assertFalse ( crypto.OptionPriceLowerOrEqualThanPercentUp(optionPrice));
    }

    @Test
    void ItShouldBeTrueWhenValidateOptionPriceInARangeOfFiveUpAndDown() {
        var crypto=  aCryto().withPrice(10).build();
        var optionPrice =  10;
        assertTrue( crypto.validateOptionPriceInARangeOfFiveUpAndDown(optionPrice));
    }


    @Test
    void ItShouldBefalseWhenValidateOptionPriceInARangeOfFiveUpAndDown() {
        var crypto=  aCryto().withPrice(10).build();
        var optionPrice =  9;
        assertFalse( crypto.validateOptionPriceInARangeOfFiveUpAndDown(optionPrice));
    }



    @Test
    void ItShouldBeTrueWhenOptionPriceHigherThanQuotePrice() {
        var crypto=  aCryto().withPrice(10).build();
        var optionPrice =  15;
        assertTrue ( crypto.OptionPriceHigherThanQuotePrice(optionPrice));
    }

    @Test
    void ItShouldBeFalseWhenOptionPriceHigherThanQuotePrice() {
        var crypto=  aCryto().withPrice(10).build();
        var optionPrice =  9;
        assertFalse ( crypto.OptionPriceHigherThanQuotePrice(optionPrice));
    }


    @Test
    void ItShouldBeTrueWhenOptionPriceLowerThanQuotePrice()  {
        var crypto=  aCryto().withPrice(10).build();
        var optionPrice =  9;
        assertTrue ( crypto.OptionPriceLowerThanQuotePrice(optionPrice));
    }

    @Test
    void ItShouldBeFalseWhenOptionPriceLowerThanQuotePrice()  {
        var crypto=  aCryto().withPrice(10).build();
        var optionPrice =  15;
        assertFalse ( crypto.OptionPriceLowerThanQuotePrice(optionPrice));
    }




}