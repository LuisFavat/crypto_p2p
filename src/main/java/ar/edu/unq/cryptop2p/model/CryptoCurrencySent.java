package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;

public class CryptoCurrencySent extends State {



    public void execute(Action action, Executor executor) throws ConfirmReceptionException, MakeTransferException { action.execute(this,executor);

    }

    public void  makeTransfer(Executor executor) throws MakeTransferException
    {throw new MakeTransferException (" Do not can to make a transfer cause state is CryptoCurrencySent"); } // Do not can to make a transfer cause state is CryptoCurrencySent" }

    public void  confirmReception(Executor executor)  throws ConfirmReceptionException
    {throw new ConfirmReceptionException( " Do not can to Confirm Reception cause state is CVUSent" );  } // Do not can to Confirm Reception cause state is CVUSent" }

    public  void  cancel (Executor executor)   {executor.cancel();}

}

