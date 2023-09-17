package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.model.Executor;
import ar.edu.unq.cryptop2p.model.Transaction;

public class ExecutorBuilder {

    private Transaction transaction;

    public static ExecutorBuilder anExecutor() {return new ExecutorBuilder(); }


    public  ExecutorBuilder withTransaction(Transaction aTransaction)
    {
        transaction = aTransaction;
       return this;
    }

    public Executor build()
    {
        Executor executor = new Executor(transaction);
        return executor;
    }
}
