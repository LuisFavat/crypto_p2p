package ar.edu.unq.model;


import ar.edu.unq.cryptop2p.builders.OptionConcreteBuilder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.assertEquals;



class OptionTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void ItShouldBeSamePriceWhenSettingPrice() {

        var option = OptionConcreteBuilder.anyOption().withPrice(5.00).build();

        assertEquals(5.00, option.getPrice());
    }

    @Test
    void ItShouldBeSameUnitsWhenSettingUnits(){

        var option = OptionConcreteBuilder.anyOption().withCryptoAmount(2).build();

        assertEquals(2, option.getCryptoAmount());
    }

    @Test
    void ItShouldBeExpect10WhenGetTheAmountPriceInPesos() {
        var option = OptionConcreteBuilder.anyOption().withPrice(5.00).withCryptoAmount(2).build();

        assertEquals(10.00, option.amountPriceInPesos());
    }

    @AfterEach
    void tearDown() {
    }
}