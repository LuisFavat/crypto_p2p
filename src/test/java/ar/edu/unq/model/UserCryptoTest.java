package ar.edu.unq.model;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ar.edu.unq.cryptop2p.model.exceptions.InvalidReputationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserCryptoTest {
    @Test
    void ItShouldBeGetThenNameWhenCreatingAUser() {
        var user = aUserCrypto().withName("Juan").build();

        assertEquals("Juan", user.getName());
    }


    @Test
    void ItShouldBeGetThenSurnameWhenCreatingAUser() {
        var user = aUserCrypto().withSurname("ChanKein").build();

        assertEquals("ChanKein", user.getSurname());
    }


    @Test
    void ItShouldBeGetThenAddressWhenCreatingAUser() {
        var user = aUserCrypto().withAddress("Elm Street 120").build();

        assertEquals("Elm Street 120", user.getAddress());
    }

    @Test
    void ItShouldBeGetThenCVUWhenCreatingAUser() {
        var user = aUserCrypto().withCvu("1234AB").build();

        assertEquals("1234AB", user.getCvu());
    }


    @Test
    void ItShouldBeGetThenCryptoAddressUWhenCreatingAUser() {
        var user = aUserCrypto().withCryptoAddress("fbb123").build();

        assertEquals("fbb123", user.getCryptoAddress());
    }


    @Test
    void ItShouldBeIncreaseTheNumberOfOperationUWhenAddingOperations() {
        var user = aUserCrypto().build();
        user.addOperation();
        user.addOperation();
        user.addOperation();

        assertEquals(3, user.getNumberOfOperation());
    }

    @Test
    void ItShouldBeIncreaseTheScoresUWhenAddingScores() {
        var user = aUserCrypto().build();
        user.addScore(5);
        user.addScore(2);
        assertEquals(7, user.getScores());
    }

    @Test
    void ItShouldBeGetTheReputationAccordingTheScoresAndOperations() throws InvalidReputationException {
        var user = aUserCrypto().build();
        user.addOperation();
        user.addOperation();
        user.addOperation();
        user.addScore(5);
        user.addScore(2);
        assertEquals(7 / 3, user.reputation());
    }


    @Test
    void ItShouldBeThrowsExceptionWhenGettingReputationWithoutOperations()  {
        var user = aUserCrypto().build();
        user.addScore(5);
        assertThrows( InvalidReputationException.class, user::reputation);
    }

}