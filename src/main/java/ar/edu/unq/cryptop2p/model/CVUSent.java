package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.jetbrains.annotations.NotNull;

public class CVUSent extends State {



    public void execute(@NotNull Action action, Executor executor) throws ConfirmReceptionException, MakeTransferException { action.execute(this,executor);

    }

    public void  makeTransfer(Executor executor) throws MakeTransferException
    {throw new MakeTransferException (" Do not can to make a transfer cause state is CryptoCurrencySent"); } // Do not can to make a transfer cause state is CryptoCurrencySent" }

    public void  confirmReception(@NotNull Executor executor) throws ConfirmReceptionException { executor.confirmReception();}
    public  void  cancel (@NotNull Executor executor)   {executor.cancel() ;}


}
