package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.jetbrains.annotations.NotNull;

public class MakeTransfer extends Action {


    public  void  execute( Transaction transaction) throws MakeTransferException, ConfirmReceptionException {
        transaction.getState().makeTransfer(transaction);


    }
}
