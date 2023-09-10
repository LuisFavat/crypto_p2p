package ar.edu.unq.model;
import ar.edu.unq.cryptop2p.model.UserCrypto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class UserCryptoTest {
    @Test
    void ItShouldBeGetThenNameWhenCreatingAUser() {
        var user = new UserCrypto();
        user.setName("Juan");

        assertEquals("Juan",user.getName());
    }

}
