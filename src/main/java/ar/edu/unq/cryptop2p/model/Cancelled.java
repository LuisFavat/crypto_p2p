package ar.edu.unq.cryptop2p.model;

public class Cancelled extends State{



    public void execute(Action action,Executor executor) { action.execute(this,executor); }

    public void  makeTransfer(Executor executor)  {} // Do nothing

    public void  confirmReception(Executor executor)  {} // Do nothing

    public  void  cancel (Executor executor)  {} // Do nothing

}

