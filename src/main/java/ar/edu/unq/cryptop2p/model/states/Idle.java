package ar.edu.unq.cryptop2p.model.states;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;

import static ar.edu.unq.cryptop2p.model.validators.Validator.response;

public class Idle extends State {


    public Transaction makeTransfer(@NotNull Transaction transaction) throws MakeTransferException { return transaction.makeTransfer();}


    public Transaction confirmReception(Transaction transaction)  throws ConfirmReceptionException
    {
      var message = "Do not can confirm reception cause the tansfer has not been done yet";
      response(message, HttpStatus.PRECONDITION_FAILED);
      throw new ConfirmReceptionException(message ) ;}



    public  Transaction cancel (@NotNull Transaction transaction)  { return transaction.cancel();}

    public Boolean isIdle()  {return true;};
    public Boolean isCVUSent()    {return false;}
    public Boolean isCryptoCurrencySent()   {return false;}
    public Boolean isCanceled()   {return false;}


}