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
    public Cryptocurrency mockCryptocurrency = Mockito.mock(Cryptocurrency.class);

    public UserCrypto mockUser = Mockito.mock(UserCrypto.class);
    public Double price = 5.00;
    public int units= 2;

    @BeforeEach
    void setUp() {
    }

    @Test
    void ItShouldBe_GetTheSameValueOfPrice_WhenGenerateAnOptionWithAValueOfPriceByDefault() {

        Option option = new OptionCall( mockCryptocurrency, 5.00, units, mockUser);
        assertEquals(5.00, option.getPrice());
    }

    @Test
    void ItShouldBe_GetTheSameValueOfUnits_WhenGenerateAnOptionWithAValueOfUnitsByDefault() {

        Option option = new OptionCall( mockCryptocurrency, price, 2, mockUser);
        assertEquals(2, option.getUnits());
    }

    @Test
    void ItShouldBe_Expect_10_Pesos_WhenGetTheAmountPriceInPesos() {
        Option option = new OptionCall( mockCryptocurrency, 5.00, 2, mockUser);
        assertEquals(10.00, option.amountPriceInPesos());
    }

    @AfterEach
    void tearDown() {
    }
}