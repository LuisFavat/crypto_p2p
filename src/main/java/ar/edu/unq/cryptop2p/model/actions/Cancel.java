package ar.edu.unq.cryptop2p.model.actions;


import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.actions.Action;

public class Cancel  extends Action {


    public  void execute( Transaction transaction) { transaction.getState().cancel(transaction);}

}
