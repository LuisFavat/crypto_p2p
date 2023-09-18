package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.jetbrains.annotations.NotNull;

public class CVUSent extends State {


    public void makeTransfer(Transaction transaction) throws MakeTransferException, ConfirmReceptionException {
        {
            throw new MakeTransferException("Do not can to make a transfer cause state is CryptoCurrencySent");
        } // Do not can to make a transfer cause state is CryptoCurrencySent
    }

    public void confirmReception(@NotNull Transaction transaction) throws ConfirmReceptionException {
        { transaction.confirmReception();}
    }

    public void cancel(@NotNull Transaction transaction) {
        { transaction.cancel(); }
    }

    public Boolean isIdle()  {return false;};
    public Boolean isCVUSent()    {return true;}
    public Boolean isCryptoCurrencySent()   {return false;}
    public Boolean isCanceled()   {return false;}
}
