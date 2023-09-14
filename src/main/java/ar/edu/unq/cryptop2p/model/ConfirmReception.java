package ar.edu.unq.cryptop2p.model;

public class ConfirmReception extends Action {

    public  void execute(State state, Transaction transaction) {
        state.confirmReception(transaction);;

    };
}
