package ar.edu.unq.cryptop2p.model.states;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.jetbrains.annotations.NotNull;

public class CryptoCurrencySent extends State {


    public Transaction makeTransfer(Transaction transaction) throws MakeTransferException
    {throw new MakeTransferException (" Do not can to make a transfer cause CryptoCurrency has just been sent"); }

    public Transaction confirmReception(Transaction transaction)  throws ConfirmReceptionException
    {throw new ConfirmReceptionException( " Do not can to Confirm Reception cause  CryptoCurrency has just been sent" );  }

    public Transaction cancel (@NotNull Transaction transaction)  { return transaction.cancel();}

    public Boolean isIdle()  {return false;};
    public Boolean isCVUSent()    {return false;}
    public Boolean isCryptoCurrencySent()   {return true;}
    public Boolean isCanceled()   {return false;}

}

