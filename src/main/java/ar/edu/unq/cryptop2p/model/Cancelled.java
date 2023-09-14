package ar.edu.unq.cryptop2p.model;

public class Cancelled extends State{


    public void execute(Action action,Transaction transaction) { action.execute(this,transaction); }

    public void  makeTransfer(Transaction transaction)  {} // Do nothing

    public void  confirmReception(Transaction transaction)  {} // Do nothing

    public  void  cancel (Transaction transaction)  {} // Do nothing

}

