package ar.edu.unq.cryptop2p.model;

public class ConfirmReception extends Action {

    public  void execute(State state, Executor executor) {
        state.confirmReception(executor);;

    };
}
