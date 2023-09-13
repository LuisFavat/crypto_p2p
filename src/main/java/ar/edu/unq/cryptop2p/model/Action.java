package ar.edu.unq.cryptop2p.model;

public abstract class Action {
    protected  Transaction transaction ;

    protected Action(Transaction transaction) {
        this.transaction = transaction;
    }

    public abstract void execute();


}