package ar.edu.unq.model;

import ar.edu.unq.cryptop2p.model.states.Cancelled;
import org.junit.jupiter.api.Test;
import static ar.edu.unq.cryptop2p.builders.TransactionBuilder.aTransaction;
import static ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
import static ar.edu.unq.cryptop2p.helpers.ActionType.MAKETRANSFER;
import static ar.edu.unq.cryptop2p.builders.ActionBuilder.anAction;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActionTest {

    @Test
    void ItShouldBeCVUSentStateWhenMakeTransferActionExecuteTransactionWithIdleStateByDefault() throws Exception {

        var seller = aUserCrypto().build();
        var transaction = aTransaction().withSeller(seller).build();

        var makeTransfer = anAction(MAKETRANSFER).build();
        makeTransfer.execute(transaction);
        assertTrue(transaction.isCVUSent());

    }

    @Test
    void ItShouldBeCanceledWhenMakeTransferActionExecuteTransactionWithCanceledState() throws Exception {

        var seller = aUserCrypto().build();

        var transaction = aTransaction().withSeller(seller).withState(new Cancelled()).build();

        var makeTransfer = anAction(MAKETRANSFER).build();
        makeTransfer.execute(transaction);

        assertTrue(transaction.isCanceled());

    }
}
