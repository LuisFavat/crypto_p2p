package ar.edu.unq.cryptop2p.model;

public class Cancel  extends Action{


    public  void execute(State state, Executor executor) { state.cancel(executor);}

}
