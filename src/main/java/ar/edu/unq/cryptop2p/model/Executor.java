package ar.edu.unq.cryptop2p.model;

public class Executor {
    private final Transaction transaction;

    public Executor(Transaction transaction){
        this.transaction = transaction;
    }

    public void execute() {
       transaction.getState().execute(transaction.getAction(), this);
    }

    public void cancel() {
        transaction.setState(new Cancelled());
    }

    public void makeTransfer() {
        transaction.setState(new CVUSent());
        transaction.getCounterPartyUser().moneyTransfer(transaction.getAddress(), transaction.getBank());
        // notify sent
    }

    public void confirmReception() {
        transaction.setState(new CryptoCurrencySent());
        if (transaction.getUser().checkTransfer()) {
            transaction.getUser().sendCryptoCurrency(transaction.getCryptoCurrency(), transaction.getCounterPartyUser());
            // Finish Transaction
        }
    }


}