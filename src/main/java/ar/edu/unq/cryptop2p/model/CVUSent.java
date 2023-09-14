package ar.edu.unq.cryptop2p.model;

public class CVUSent extends State {


    public void execute(Action action, Transaction transaction) { action.execute(this,transaction); }

    public void  makeTransfer(Transaction transaction)  {} //" Do not can to make a transfer cause state is CryptoCurrencySent" }

    public void  confirmReception(Transaction transaction)   {} ///" Do not can to Confirm Reception cause state is CVUSent" }

    public  void  cancel (Transaction transaction)   {transaction.cancel() ;}


}
