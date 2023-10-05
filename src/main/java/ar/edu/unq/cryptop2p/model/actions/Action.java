package ar.edu.unq.cryptop2p.model.actions;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.CancelException;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;

public abstract class Action {


    public  Transaction execute(Transaction transaction) throws ConfirmReceptionException, MakeTransferException, CancelException {
    return new Transaction(); }

}