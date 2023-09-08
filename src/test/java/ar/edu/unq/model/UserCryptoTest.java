package ar.edu.unq.model;
import ar.edu.unq.cryptop2p.model.UserCrypto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



public class UserCryptoTest {
    @Test
    void ItShouldBeGetThenNameWhenCreatingAUser() {
        var user = new UserCrypto();
        user.setName("Juan");

        assertEquals("Juan",user.getName());
    }

}
