package ar.edu.unq.cryptop2p.model;

public class CryptoCurrencySent extends State {


    public void execute(Action action,Transaction transaction) { action.execute(this,transaction); }

    public void  makeTransfer(Transaction transaction)  {} //" Do not can to make a transfer cause state is CryptoCurrencySent" }

    public void  confirmReception(Transaction transaction)  { transaction.confirmReception();}

    public  void  cancel (Transaction transaction)   {transaction.cancel();}

}

