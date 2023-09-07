package ar.edu.unq.cryptop2p.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest

class OptionTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void ItShouldBe_SamePrice_When_SettingPrice() {

        Option option = new OptionCall();
        option.setPrice(5.00);

        assertEquals(5.00, option.getPrice());
    }

    @Test
    void ItShouldBe_SameUnits_When_SettingUnits(){

        Option option = new OptionCall();
        option.setUnits(2);

        assertEquals(2, option.getUnits());
    }

    @Test
    void ItShouldBe_Expect_10_WhenGetTheAmountPriceInPesos() {
        Option option = new OptionCall();
        option.setUnits(2);
        option.setPrice(5.00);

        assertEquals(10.00, option.amountPriceInPesos());
    }

    @AfterEach
    void tearDown() {
    }
}