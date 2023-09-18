package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import org.jetbrains.annotations.NotNull;

public class ConfirmReception extends Action {

    public void  execute(Transaction transaction) throws ConfirmReceptionException {
                   transaction.getState().confirmReception(transaction);

    };
}
