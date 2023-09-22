package ar.edu.unq.cryptop2p.model;



public class Cancel  extends Action{


    public  void execute( Transaction transaction) { transaction.getState().cancel(transaction);}

}
