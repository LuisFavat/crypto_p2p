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




}