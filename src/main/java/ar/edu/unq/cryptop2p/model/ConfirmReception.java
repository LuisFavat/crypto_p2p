package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;

public class ConfirmReception extends Action {

    public  void execute(State state, Executor executor) throws ConfirmReceptionException {
        state.confirmReception(executor);;

    };
}
