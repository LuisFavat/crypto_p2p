package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import ar.edu.unq.cryptop2p.model.state.CVUSent;
import ar.edu.unq.cryptop2p.model.state.Cancelled;
import ar.edu.unq.cryptop2p.model.state.CryptoCurrencySent;

public class Executor {
    private final Transaction transaction;

    public Executor(Transaction transaction){
        this.transaction = transaction;
    }

    public void execute() throws ConfirmReceptionException, MakeTransferException {
      transaction.getState().execute(transaction.getAction(), this);


    }

    public void cancel() {
        transaction.getUser().substractReputation(20);
        transaction.setState(new Cancelled() );

    }

    public void makeTransfer()  throws  MakeTransferException {
        transaction.setState(new CVUSent());
        transaction.getCounterPartyUser().moneyTransfer(transaction.getAddress(), transaction.getBank());
    }

    public void confirmReception() throws ConfirmReceptionException {

        transaction.setState(new CryptoCurrencySent());
        if (transaction.getUser().checkTransfer()) {
            transaction.getUser().sendCryptoCurrency(transaction.getCryptoCurrency(), transaction.getCounterPartyUser());
            // Finish Transaction

        }

    }


}