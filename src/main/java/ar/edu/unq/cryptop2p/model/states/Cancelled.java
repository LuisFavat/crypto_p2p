package ar.edu.unq.cryptop2p.model.states;


import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.CancelException;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;


public class Cancelled extends State {

    public  Transaction makeTransfer(Transaction transaction) throws MakeTransferException {
        throw new MakeTransferException("Do not can to make a transfer cause the transaction has been cancelled");
    }

    public  Transaction confirmReception(Transaction transaction) throws ConfirmReceptionException
    {throw new ConfirmReceptionException( "Do not can to Confirm Reception cause the transaction has been cancelled" );  }

    public   Transaction  cancel (Transaction transaction) throws CancelException {throw new CancelException( "Do not can to Confirm Reception cause the transaction has been cancelled" );  }

    public Boolean isIdle()  {return false;};
    public Boolean isCVUSent()    {return false;}
    public Boolean isCryptoCurrencySent()   {return false;}
    public Boolean isCanceled()   {return true;}

}

