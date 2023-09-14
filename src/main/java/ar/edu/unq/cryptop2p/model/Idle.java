package ar.edu.unq.cryptop2p.model;

public class Idle extends State {

    public void execute(Action action,Executor executor) { action.execute(this, executor); }

    public void  makeTransfer(Executor executor) {executor.makeTransfer();}


   public void  confirmReception(Executor executor) { executor.confirmReception();}


    public  void  cancel (Executor executor)  {executor.cancel();}



}