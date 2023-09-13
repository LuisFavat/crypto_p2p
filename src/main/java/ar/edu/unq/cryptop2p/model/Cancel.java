package ar.edu.unq.cryptop2p.model;

public class Cancel  extends Action{


   protected Cancel (Transaction transaction) {
        super(transaction);

           };

    public  void execute() {
       this.transaction.setState(new Cancelled());

    };
}
