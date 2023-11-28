package ar.edu.unq.model.dto;

import ar.edu.unq.cryptop2p.model.dto.CryptoAmountDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CryptoAmountDtoTests {

    @Test
    public void contructorTest()
    {
        var amount = 1;
        var name = "cryptoName";
        var cryptoAmountDTO = new CryptoAmountDto(amount, name);

        assertEquals(amount, cryptoAmountDTO.getAmount());
        assertEquals(name, cryptoAmountDTO.getCryptoName());
    }
}