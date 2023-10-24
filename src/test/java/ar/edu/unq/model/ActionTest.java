package ar.edu.unq.model;

import static ar.edu.unq.cryptop2p.helpers.StateType.*;
import ar.edu.unq.cryptop2p.model.exceptions.CancelException;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static ar.edu.unq.cryptop2p.builders.TransactionBuilder.aTransaction;
import static ar.edu.unq.cryptop2p.builders.UserCryptoBuilder.aUserCrypto;
import static ar.edu.unq.cryptop2p.helpers.ActionType.MAKETRANSFER;
import static ar.edu.unq.cryptop2p.builders.ActionBuilder.anAction;
import static org.junit.jupiter.api.Assertions.*;

public class ActionTest {

    @Test
    void ItShouldBeCVUSentStateWhenMakeTransferActionExecuteTransactionWithIdleStateByDefault() throws Exception {

        var seller = aUserCrypto().build();
        var transaction = aTransaction().withSeller(seller).build();

        var makeTransfer = anAction(MAKETRANSFER).build();
        var aTransaction = makeTransfer.execute(transaction);
        assertTrue(aTransaction.isCVUSent());

    }

    @Test
    void ItShouldBeCanceledWhenMakeTransferActionExecuteTransactionWithCanceledState() throws ConfirmReceptionException, MakeTransferException, CancelException, PreconditionFailedException, ParseException {

        var seller = aUserCrypto().build();

        var transaction = aTransaction().withSeller(seller).withState(CANCELLED).build();

        var makeTransfer = anAction(MAKETRANSFER).build();

        assertThrows ( MakeTransferException.class , ()-> makeTransfer.execute(transaction));

        assertTrue(transaction.isCanceled());


    }

    }

