package ar.edu.unq.cryptop2p.model.exceptions;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(){
        super("The item is not found");
        this.setStackTrace(new StackTraceElement[0]);
    }
}
