package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;

public class MakeTransfer extends Action {


    public  void  execute(State state,Executor executor) throws MakeTransferException, ConfirmReceptionException {
        state.makeTransfer(executor);


    }
}