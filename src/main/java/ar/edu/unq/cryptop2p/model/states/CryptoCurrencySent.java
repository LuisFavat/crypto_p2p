package ar.edu.unq.cryptop2p.model.states;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;

import static ar.edu.unq.cryptop2p.model.validators.Validator.response;

public class CryptoCurrencySent extends State {


    public Transaction makeTransfer(Transaction transaction) throws MakeTransferException
    {
        var message = " Do not can make a transfer cause CryptoCurrency has just been sent";
        response(message, HttpStatus.PRECONDITION_FAILED);
        throw new MakeTransferException (message); }

    public Transaction confirmReception(Transaction transaction)  throws ConfirmReceptionException
    {
        var message = "Do not can confirm reception cause  CryptoCurrency has just been sent";
        response(message, HttpStatus.PRECONDITION_FAILED);
        throw new ConfirmReceptionException(message );  }

    public Transaction cancel (@NotNull Transaction transaction)  { return transaction.cancel();}

    public Boolean isIdle()  {return false;};
    public Boolean isCVUSent()    {return false;}
    public Boolean isCryptoCurrencySent()   {return true;}
    public Boolean isCanceled()   {return false;}

}

