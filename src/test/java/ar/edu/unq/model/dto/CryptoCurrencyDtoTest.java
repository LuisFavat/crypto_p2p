package ar.edu.unq.model.dto;

import ar.edu.unq.cryptop2p.model.dto.CryptoAmountDto;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CryptoCurrencyDtoTest {

    @Test
    public void fullContructorTest()
    {
        var amount = 1D;
        var name = "cryptoName";
        var cryptoCurrencyDTO = new CryptoCurrencyDto(name, amount);

        assertEquals(amount, cryptoCurrencyDTO.getPrice());
        assertEquals(name, cryptoCurrencyDTO.getName());
    }

    @Test
    public void toModelTest()
    {

        var amount = 1D;
        var name = "cryptoName";
        var cryptoCurrencyDTO = new CryptoCurrencyDto(name, amount);

        var crypto = cryptoCurrencyDTO.toModel();

        assertEquals(amount, crypto.getPrice());
        assertEquals(name, crypto.getName());

    }

    @Test
    public void setterTest()
    {
        var amount = 1;
        String name = "aName";

        var cryptoAmountDTO = new CryptoAmountDto();
        cryptoAmountDTO.setAmount(amount);
        cryptoAmountDTO.setCryptoName(name);

        assertEquals(amount, cryptoAmountDTO.getAmount());
        assertEquals(name, cryptoAmountDTO.getCryptoName());
    }
}
