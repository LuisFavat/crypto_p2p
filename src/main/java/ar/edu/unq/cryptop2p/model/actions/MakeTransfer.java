package ar.edu.unq.cryptop2p.model.actions;

import ar.edu.unq.cryptop2p.model.Executor;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import ar.edu.unq.cryptop2p.model.state.State;

public class MakeTransfer extends Action {


    public  void  execute(State state,Executor executor) throws MakeTransferException, ConfirmReceptionException {
        state.makeTransfer(executor);


    }
}
