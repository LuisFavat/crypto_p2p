package ar.edu.unq.cryptop2p.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract  class State {

   public abstract void execute(Action action,Transaction transaction);

    public abstract void  makeTransfer(Transaction transaction)  ;
    public abstract void   confirmReception(Transaction transaction) ;
    public  abstract void  cancel(Transaction transaction) ;
}