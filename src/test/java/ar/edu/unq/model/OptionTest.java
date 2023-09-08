package ar.edu.unq.model;

import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.OptionCall;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static ar.edu.unq.model.builders.OptionCallBuilder.*;

import static org.junit.jupiter.api.Assertions.assertEquals;



class OptionTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void ItShouldBeSamePriceWhenSettingPrice() {

        var option = anOption().withPrice(5.00).build();

        assertEquals(5.00, option.getPrice());
    }

    @Test
    void ItShouldBeSameUnitsWhenSettingUnits(){

        var option = anOption().withUnits(2).build();

        assertEquals(2, option.getUnits());
    }

    @Test
    void ItShouldBeExpect10WhenGetTheAmountPriceInPesos() {
        var option = anOption().withPrice(5.00).withUnits(2).build();

        assertEquals(10.00, option.amountPriceInPesos());
    }

    @AfterEach
    void tearDown() {
    }
}