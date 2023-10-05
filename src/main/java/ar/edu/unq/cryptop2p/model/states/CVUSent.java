package ar.edu.unq.cryptop2p.model.states;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.jetbrains.annotations.NotNull;

public class CVUSent extends State {


    public Transaction makeTransfer(Transaction transaction) throws MakeTransferException, ConfirmReceptionException {
        {
            throw new MakeTransferException("Do not can to repeat to make a transfer cause CVU Has just been sent");
        }
    }

    public Transaction confirmReception(@NotNull Transaction transaction)  {
        {return  transaction.confirmReception();}
    }

    public Transaction cancel(@NotNull Transaction transaction) {
        { return transaction.cancel(); }
    }

    public Boolean isIdle()  {return false;};
    public Boolean isCVUSent()    {return true;}
    public Boolean isCryptoCurrencySent()   {return false;}
    public Boolean isCanceled()   {return false;}
}
