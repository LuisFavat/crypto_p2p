package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.jetbrains.annotations.NotNull;

public class Cancelled extends State{



   // public void execute(@NotNull Action action, Transaction transaction) throws ConfirmReceptionException, MakeTransferException {  action.execute(this,transaction);}

    public  void  makeTransfer(Transaction transaction)  {} // Do nothing

    public  void confirmReception(Transaction transaction)  {}// Do nothing

    public   void  cancel (Transaction transaction)  {} // Do nothing

    public Boolean isIdle()  {return false;};
    public Boolean isCVUSent()    {return false;}
    public Boolean isCryptoCurrencySent()   {return false;}
    public Boolean isCanceled()   {return true;}

}

