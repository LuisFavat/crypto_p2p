package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;

public abstract class Action {


    public abstract void execute(State state,Executor executor) throws ConfirmReceptionException, MakeTransferException;


}