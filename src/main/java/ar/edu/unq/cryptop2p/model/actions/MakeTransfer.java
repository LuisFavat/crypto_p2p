package ar.edu.unq.cryptop2p.model.actions;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;

public class MakeTransfer extends Action {


    public  void  execute( Transaction transaction) throws MakeTransferException, ConfirmReceptionException {
        transaction.getState().makeTransfer(transaction);


    }
}
