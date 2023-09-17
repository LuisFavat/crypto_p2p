package ar.edu.unq.cryptop2p.model.actions;

import ar.edu.unq.cryptop2p.model.Executor;
import ar.edu.unq.cryptop2p.model.state.State;

public class Cancel  extends Action{


    public  void execute(State state, Executor executor) { state.cancel(executor);}

}
