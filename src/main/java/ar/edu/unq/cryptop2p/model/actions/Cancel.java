package ar.edu.unq.cryptop2p.model.actions;


import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.CancelException;

public class Cancel  extends Action {


    public  Transaction execute(Transaction transaction) throws CancelException {  return transaction.getState().cancel(transaction);

    }

}
