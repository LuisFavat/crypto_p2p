package ar.edu.unq.model;
import ar.edu.unq.cryptop2p.model.UserCrypto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



public class UserCryptoTest {
    	@Test
	void it_should_create_a_user_when_instantiting_one() {
		var name = "Jean";
		var surname = "Valjean";
		var adress = "Plaza de los Vosgos nro 6";
		var email = "lesmiserables@google.com";
		var cvu = "1234567890123456789012";
		var cryptoAddress = "123456";
        var user = new UserCrypto(0L, name, surname, adress, email, cvu, cryptoAddress);

        assertEquals(0L, user.getId());
		assertEquals(name, user.getName());
		assertEquals(surname, user.getSurname());
		assertEquals(adress, user.getAddress());
		assertEquals(email, user.getEmail());
		assertEquals(cvu, user.getCvu());
		assertEquals(cryptoAddress, user.getCryptoAddress());
	}
}
