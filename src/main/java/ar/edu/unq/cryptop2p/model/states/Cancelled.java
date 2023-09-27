package ar.edu.unq.cryptop2p.model.states;


import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.states.State;

public class Cancelled extends State {

    public  void  makeTransfer(Transaction transaction)  {}

    public  void confirmReception(Transaction transaction)  {}

    public   void  cancel (Transaction transaction)  {}

    public Boolean isIdle()  {return false;};
    public Boolean isCVUSent()    {return false;}
    public Boolean isCryptoCurrencySent()   {return false;}
    public Boolean isCanceled()   {return true;}

}

