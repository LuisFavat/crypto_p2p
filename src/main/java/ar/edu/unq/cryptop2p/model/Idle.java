package ar.edu.unq.cryptop2p.model;

public class Idle extends State {

    public void execute(Action action,Transaction transaction) { action.execute(this,transaction); }

    public void  makeTransfer(Transaction transaction) {}
                                                    // sent cryptoCurrency
                                                   // motify sent}


   public void  confirmReception(Transaction transaction) {} // check CVU Sent
                                    // send Cryptocurrency
                                     // Finish Transaction}

    public  void  cancel (Transaction transaction)  {transaction.setState(new Cancelled());}



}