package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract  class State {

    public State()  {}

    public abstract void makeTransfer(Transaction transaction) throws MakeTransferException, ConfirmReceptionException;
    public abstract void confirmReception(Transaction transaction) throws ConfirmReceptionException;
    public  abstract void cancel(Transaction transaction) ;

    public abstract Boolean isIdle();
    public abstract  Boolean isCVUSent();
    public abstract  Boolean isCryptoCurrencySent();
    public abstract  Boolean isCanceled();


}