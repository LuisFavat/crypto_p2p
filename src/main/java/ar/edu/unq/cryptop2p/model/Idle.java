package ar.edu.unq.cryptop2p.model;

public class Idle extends State {

    public void execute(Action action,Transaction transaction) { action.execute(this,transaction); }

    public void  makeTransfer(Transaction transaction) {transaction.makeTransfer();}


   public void  confirmReception(Transaction transaction) { transaction.confirmReception();}


    public  void  cancel (Transaction transaction)  {transaction.cancel();}



}