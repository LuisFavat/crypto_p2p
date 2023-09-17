package ar.edu.unq.cryptop2p.model.state;

import ar.edu.unq.cryptop2p.model.Executor;
import ar.edu.unq.cryptop2p.model.State;
import ar.edu.unq.cryptop2p.model.actions.Action;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;

public class Cancelled extends State{



    public void execute(Action action, Executor executor) throws ConfirmReceptionException, MakeTransferException {  action.execute(this,executor);}

    public  void  makeTransfer(Executor executor)  {} // Do nothing

    public  void confirmReception(Executor executor)  {}// Do nothing

    public   void  cancel (Executor executor)  {} // Do nothing

}

