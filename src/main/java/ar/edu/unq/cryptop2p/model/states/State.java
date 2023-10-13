package ar.edu.unq.cryptop2p.model.states;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.CancelException;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract  class State {

    public State()  {}

    public abstract Transaction makeTransfer(Transaction transaction) throws MakeTransferException, ConfirmReceptionException;
    public abstract Transaction confirmReception(Transaction transaction) throws ConfirmReceptionException;
    public  abstract Transaction cancel(Transaction transaction) throws CancelException;

    public abstract Boolean isIdle();
    public abstract  Boolean isCVUSent();
    public abstract  Boolean isCryptoCurrencySent();
    public abstract  Boolean isCanceled();

}