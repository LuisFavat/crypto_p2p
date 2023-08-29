package ar.edu.unq.model;
import ar.edu.unq.cryptop2p.model.UserCrypto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



public class UserCryptoTest {
    	@Test
	void SePuedeInstanciarUnUsuario() {
        var user = new UserCrypto(0L, "Jean", "Valjean", "Plaza de los Vosgos nro 6", "lesmiserables@google.com", "1234567890123456789012", "123456");

        assertEquals("a","a");
	}
}
