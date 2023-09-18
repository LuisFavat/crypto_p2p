package ar.edu.unq.cryptop2p.model;

import org.jetbrains.annotations.NotNull;

public class Cancel  extends Action{


    public  void execute(@NotNull State state, Transaction transaction) { state.cancel(transaction);}

}
