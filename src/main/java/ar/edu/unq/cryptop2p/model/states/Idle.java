package ar.edu.unq.cryptop2p.model.states;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.jetbrains.annotations.NotNull;

public class Idle extends State {


    public void makeTransfer(@NotNull Transaction transaction) throws MakeTransferException { transaction.makeTransfer();}


    public void confirmReception(Transaction transaction)  throws ConfirmReceptionException
    {throw new ConfirmReceptionException( " Do not can to Confirm Reception cause the tansfer has not been done yet);  } // Do not can to Confirm Reception cause state is CVUSent") ;}



    public  void cancel (@NotNull Transaction transaction)  { transaction.cancel();}

    public Boolean isIdle()  {return true;};
    public Boolean isCVUSent()    {return false;}
    public Boolean isCryptoCurrencySent()   {return false;}
    public Boolean isCanceled()   {return false;}


}