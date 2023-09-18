package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import org.jetbrains.annotations.NotNull;

public class ConfirmReception extends Action {

    public void  execute(@NotNull State state, Transaction transaction) throws ConfirmReceptionException {
                   state.confirmReception(transaction);

    };
}
