package ar.edu.unq.model;

import ar.edu.unq.cryptop2p.model.*;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.junit.jupiter.api.Test;
import static ar.edu.unq.cryptop2p.builders.TransactionBuilder.aTransaction;
import static ar.edu.unq.cryptop2p.builders.ExecutorBuilder.anExecutor;
import static  ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
import static ar.edu.unq.cryptop2p.builders.OptionConcreteBuilder.anyOption;
import static ar.edu.unq.cryptop2p.builders.BankBuilder.aBank;
import static org.junit.jupiter.api.Assertions.*;

class ExecutorTest {

    @Test
    void ItShouldBecomeToICVUSentStateAndMoneyTransfersIsNotEmptyWhenExecutingMakeTransferWithIdleState() throws ConfirmReceptionException, MakeTransferException {
        var bank = aBank().build();
        var seller = aUserCrypto().withCvu("CVU1").withBank(bank).build();
        var buyer =  aUserCrypto().build();
        var optionPut = anyOption().withUser(seller).buildOptionPut();
        var transaction = aTransaction()
                .wwithOption(optionPut)
                .withCounterPartyUser(buyer)
                .withState(new Idle())
                .withAction(new MakeTransfer()).build();

        var executor = anExecutor().withTransaction(transaction).build();

        executor.execute();;

        assertEquals(CVUSent.class.getName(),  transaction.getState().getClass().getName() );
        assertFalse(seller.getBank().getMoneyTransfers().isEmpty());
    }

    @Test
    void ItShouldBecomeToCancelledStateAndMoneyTransfersIsEmptyWhenExecutingCancelWithIdleState() throws ConfirmReceptionException, MakeTransferException {
        var bank = aBank().build();
        var seller = aUserCrypto().withCvu("CVU1").withBank(bank).build();
        var buyer =  aUserCrypto().build();
        var optionPut = anyOption().withUser(seller).buildOptionPut();
        var transaction = aTransaction()
                .wwithOption(optionPut)
                .withCounterPartyUser(buyer)
                .withState(new Idle())
                .withAction(new Cancel()).build();

        var executor = anExecutor().withTransaction(transaction).build();

        executor.execute();;

        assertEquals(Cancelled.class.getName(),  transaction.getState().getClass().getName() );
        assertTrue(seller.getBank().getMoneyTransfers().isEmpty());
    }

    @Test
    void ItShouldBeCancelledStateAndMoneyTransfersIsEmptyWhenExecutingMakeTransferWithCancelledState() throws ConfirmReceptionException, MakeTransferException {
        var bank = aBank().build();
        var seller = aUserCrypto().withCvu("CVU1").withBank(bank).build();
        var buyer =  aUserCrypto().build();
        var optionPut = anyOption().withUser(seller).buildOptionPut();
        var transaction = aTransaction()
                .wwithOption(optionPut)
                .withCounterPartyUser(buyer)
                .withState(new Cancelled())
                .withAction(new MakeTransfer()).build();

        var executor = anExecutor().withTransaction(transaction).build();

        executor.execute();;

        assertEquals(Cancelled.class.getName(),  transaction.getState().getClass().getName() );
        assertTrue(seller.getBank().getMoneyTransfers().isEmpty());
    }


    @Test
    void ItShouldThrowsMakeTransferExceptionWhenExecutingMakeTransferWithCVUSentState() throws ConfirmReceptionException, MakeTransferException {
        var bank = aBank().build();
        var seller = aUserCrypto().withCvu("CVU1").withBank(bank).build();
        var buyer =  aUserCrypto().build();
        var optionPut = anyOption().withUser(seller).buildOptionPut();
        var transaction = aTransaction()
                .wwithOption(optionPut)
                .withCounterPartyUser(buyer)
                .withState(new CVUSent())
                .withAction(new MakeTransfer()).build();
        var executor = anExecutor().withTransaction(transaction).build();

       // assertThrows (MakeTransfer.class, executor.execute());
        assertTrue(seller.getBank().getMoneyTransfers().isEmpty());
    }

    @Test
    void cancel() {
    }

    @Test
    void makeTransfer() {
    }

    @Test
    void confirmReception() {
    }
}