package ar.edu.unq.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ar.edu.unq.cryptop2p.model.exceptions.InvalidReputationException;
import org.junit.jupiter.api.Test;
import static ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserCryptoTest {
    @Test
    void ItShouldBeGetThenNameWhenCreatingAUser() throws Exception {
        var user = aUserCrypto().withName("Juan").build();

        assertEquals("Juan", user.getName());
    }


    @Test
    void ItShouldBeGetThenSurnameWhenCreatingAUser() throws Exception {
        var user = aUserCrypto().withSurname("ChanKein").build();

        assertEquals("ChanKein", user.getSurname());
    }


    @Test
    void ItShouldBeGetThenAddressWhenCreatingAUser() throws Exception {
        var user = aUserCrypto().withAddress("Elm Street 120").build();

        assertEquals("Elm Street 120", user.getAddress());
    }

    @Test
    void ItShouldBeGetThenCVUWhenCreatingAUser() throws Exception {
        var user = aUserCrypto().withCvu("1234567890123456789012").build();

        assertEquals("1234567890123456789012", user.getCvu());
    }


    @Test
    void ItShouldBeGetThenCryptoAddressUWhenCreatingAUser() throws Exception {
        var user = aUserCrypto().withCryptoAddress("12345678").build();

        assertEquals("12345678", user.getCryptoAddress());
    }


    @Test
    void ItShouldBeIncreaseTheNumberOfOperationUWhenAddingOperations() throws Exception {
        var user = aUserCrypto().build();
        user.addOperation();
        user.addOperation();
        user.addOperation();

        assertEquals(3, user.getNumberOfOperation());
    }

    @Test
    void ItShouldBeIncreaseTheScoresUWhenAddingScores() throws Exception {
        var user = aUserCrypto().build();
        user.addScore(5);
        user.addScore(2);
        assertEquals(7, user.getScores());
    }

    @Test
    void ItShouldBeGetTheReputationAccordingTheScoresAndOperations() throws Exception {
        var user = aUserCrypto().build();
        user.addOperation();
        user.addOperation();
        user.addOperation();
        user.addScore(5);
        user.addScore(2);
        assertEquals(7 / 3, user.reputation());
    }


    @Test
    void ItShouldBeThrowsExceptionWhenGettingReputationWithoutOperations() throws Exception {
        var user = aUserCrypto().build();
        user.addScore(5);
        assertThrows( InvalidReputationException.class, user::reputation);
    }

}