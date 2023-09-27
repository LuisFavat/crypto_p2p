package ar.edu.unq.cryptop2p.model.actions;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.actions.Action;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;

public class ConfirmReception extends Action {

    public void  execute(Transaction transaction) throws ConfirmReceptionException {
                   transaction.getState().confirmReception(transaction);

    };
}
