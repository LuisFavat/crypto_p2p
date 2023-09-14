package ar.edu.unq.cryptop2p.model;

public class CVUSent extends State {


    public void execute(Action action, Executor executor) { action.execute(this,executor); }

    public void  makeTransfer(Executor executor)  {} //" Do not can to make a transfer cause state is CryptoCurrencySent" }

    public void  confirmReception(Executor executor)   {} ///" Do not can to Confirm Reception cause state is CVUSent" }

    public  void  cancel (Executor executor)   {executor.cancel() ;}


}
