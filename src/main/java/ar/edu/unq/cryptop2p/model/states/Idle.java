package ar.edu.unq.cryptop2p.model.states;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.jetbrains.annotations.NotNull;

public class Idle extends State {


    public Transaction makeTransfer(@NotNull Transaction transaction) throws MakeTransferException { return transaction.makeTransfer();}


    public Transaction confirmReception(Transaction transaction)  throws ConfirmReceptionException
    {throw new ConfirmReceptionException( " Do not can to Confirm Reception cause the tansfer has not been done yet") ;}



    public  Transaction cancel (@NotNull Transaction transaction)  { return transaction.cancel();}

    public Boolean isIdle()  {return true;};
    public Boolean isCVUSent()    {return false;}
    public Boolean isCryptoCurrencySent()   {return false;}
    public Boolean isCanceled()   {return false;}


}