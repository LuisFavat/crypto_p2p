package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;

public class Idle extends State {



    public void execute(Action action, Executor executor) throws ConfirmReceptionException, MakeTransferException { action.execute(this, executor);

    }

    public void  makeTransfer(Executor executor) throws MakeTransferException {executor.makeTransfer();}


   public void  confirmReception(Executor executor) throws ConfirmReceptionException { executor.confirmReception();}


    public  void  cancel (Executor executor)  {executor.cancel();}



}