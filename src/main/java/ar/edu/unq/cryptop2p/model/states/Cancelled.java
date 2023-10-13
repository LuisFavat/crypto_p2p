package ar.edu.unq.cryptop2p.model.states;


import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.CancelException;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.springframework.http.HttpStatus;

import static ar.edu.unq.cryptop2p.model.validators.Validator.response;


public class Cancelled extends State {

    public  Transaction makeTransfer(Transaction transaction) throws MakeTransferException {
       var message = "Do not can make a transfer cause the transaction has been cancelled";
        response(message, HttpStatus.PRECONDITION_FAILED);
        throw new MakeTransferException(message);
    }

    public  Transaction confirmReception(Transaction transaction) throws ConfirmReceptionException
    {   var message = "Do not can confirm reception cause the transaction has been cancelled";
        response(message, HttpStatus.PRECONDITION_FAILED);
        throw new ConfirmReceptionException( message );  }

    public   Transaction  cancel (Transaction transaction) throws CancelException {
        var message = "Do not can cancel cause the transaction has been cancelled";
        response(message, HttpStatus.PRECONDITION_FAILED);
        throw new CancelException(message) ; }

    public Boolean isIdle()  {return false;};
    public Boolean isCVUSent()    {return false;}
    public Boolean isCryptoCurrencySent()   {return false;}
    public Boolean isCanceled()   {return true;}

}

