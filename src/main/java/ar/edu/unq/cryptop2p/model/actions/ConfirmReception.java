package ar.edu.unq.cryptop2p.model.actions;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;

public class ConfirmReception extends Action {

    public   Transaction execute(Transaction transaction) throws ConfirmReceptionException {
                return   transaction.getState().confirmReception(transaction);

    };
}
