package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract  class State {

    public State()  {}

    public abstract void execute(Action action, Executor executor) throws ConfirmReceptionException, MakeTransferException;

    public abstract void makeTransfer(Executor executor) throws MakeTransferException, ConfirmReceptionException;
    public abstract void confirmReception(Executor executor) throws ConfirmReceptionException;
    public  abstract void cancel(Executor executor) ;
}