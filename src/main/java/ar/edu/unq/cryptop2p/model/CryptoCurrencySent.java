package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.jetbrains.annotations.NotNull;

public class CryptoCurrencySent extends State {


    public void makeTransfer(Transaction transaction) throws MakeTransferException
    {throw new MakeTransferException (" Do not can to make a transfer cause state is CryptoCurrencySent"); } // Do not can to make a transfer cause state is CryptoCurrencySent" }

    public void confirmReception(Transaction transaction)  throws ConfirmReceptionException
    {throw new ConfirmReceptionException( " Do not can to Confirm Reception cause state is CVUSent" );  } // Do not can to Confirm Reception cause state is CVUSent" }

    public void cancel (@NotNull Transaction transaction)  {  transaction.cancel();}

    public Boolean isIdle()  {return false;};
    public Boolean isCVUSent()    {return false;}
    public Boolean isCryptoCurrencySent()   {return true;}
    public Boolean isCanceled()   {return false;}

}

