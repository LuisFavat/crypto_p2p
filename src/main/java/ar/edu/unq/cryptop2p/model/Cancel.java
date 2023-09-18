package ar.edu.unq.cryptop2p.model;

import org.jetbrains.annotations.NotNull;

public class Cancel  extends Action{


    public  void execute( Transaction transaction) { transaction.getState().cancel(transaction);}

}
