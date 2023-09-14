package ar.edu.unq.cryptop2p.model;

public class CVUSent extends State {




    public void execute(Action action, Transaction transaction) { action.execute(this,transaction); }

    public void  makeTransfer(Transaction transaction)  {} //

    public void  confirmReception(Transaction transaction)   {} //

    public  void  cancel (Transaction transaction)   {transaction.setState(new Cancelled());}


}
