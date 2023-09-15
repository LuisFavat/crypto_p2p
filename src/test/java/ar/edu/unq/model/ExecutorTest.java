package ar.edu.unq.model;

import ar.edu.unq.cryptop2p.model.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static ar.edu.unq.cryptop2p.builders.TransactionBuilder.aTransaction;
import static ar.edu.unq.cryptop2p.builders.ExecutorBuilder.anExecutor;
import static  ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
import static ar.edu.unq.cryptop2p.builders.OptionConcreteBuilder.anyOption;
import static ar.edu.unq.cryptop2p.builders.BankBuilder.aBank;
import static org.junit.jupiter.api.Assertions.*;

class ExecutorTest {

    @Test
    void ItShouldCBecomeToICVUSentStateAndMoneyTransfersIsNotEmptyWhenExecutingATransaction() {
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
    void cancel() {
    }

    @Test
    void makeTransfer() {
    }

    @Test
    void confirmReception() {
    }
}