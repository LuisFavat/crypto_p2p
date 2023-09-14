package ar.edu.unq.cryptop2p.model;

public class MakeTransfer extends Action {


    public  void execute(State state,Transaction transaction) {
        state.makeTransfer(transaction);

    }
}
