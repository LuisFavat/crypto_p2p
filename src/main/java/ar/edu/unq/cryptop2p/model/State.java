package ar.edu.unq.cryptop2p.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract  class State {

    public State()  {}


   public abstract void execute(Action action,Executor executor);

    public abstract void  makeTransfer(Executor executor)  ;
    public abstract void   confirmReception(Executor executor) ;
    public  abstract void  cancel(Executor executor) ;
}