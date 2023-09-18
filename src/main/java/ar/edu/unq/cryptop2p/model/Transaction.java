package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.helpers.ActionType;
import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor

public class Transaction {

    private Option option;
    private State state = new Idle();
    private Action action ;
    private ActionType actionType;
    private UserCrypto counterPartyUser;



    public Transaction(Option aOption) {
        option = aOption;
    }


    public UserCrypto getCounterPartyUser() {
               return counterPartyUser;
    }

    public Date getDateTime()  {return option.getDateTime();}

    public UserCrypto getUser() {
        return option.getUser();
    }

    public String getAddress() {
        return option.getVirtualAddress();
    }

    public CryptoCurrency getCryptoCurrency() {
        return option.getCryptocurrency();
    }

    public float getAmountOfCryptoCurrency() {
        return option.getCryptoAmount();
    }

    public Double cryptoPrice() {
        return option.quote();
    }

    public Double transactionAmount() {
        return getAmountOfCryptoCurrency() * cryptoPrice();
    }

    public String nameOfTheOwnerOfTheOption() {
        return option.nameOfTheOwner();
    }

    public int numberOfOperations() {
        return option.numberOfOperation();
    }

    public float reputation() {
        return option.reputation();
    }

    public String address() {
        return option.getAddress();
    }

    public  boolean  IsValidPriceToPost() {return option.IsValidPriceToPost();};

    public void cancelySystem(){
        this.setState(new Cancelled());
    }

    public void addOperation(){
        if    ( ! isCanceled()) {
               addOperationsToUsers();
               addScoresToUsers(gainScores());;
              }
         }

    private void addOperationsToUsers(){
        getUser().addOperation();
        getCounterPartyUser().addOperation();
    }

    public boolean isCVUSent(){
          return  (state.isCVUSent());
        }

    public boolean isCryptoCurrencySent() {
        return  (state.isCryptoCurrencySent());
    }

    public boolean isIdle(){
        return  (state.isIdle());
    }

    public boolean isCanceled(){
        return  (state.isCanceled());
    }

    public void addScoresToUsers(int scores){
        getUser().addScore(scores);
        getCounterPartyUser().addScore(scores);
    }


    private int gainScores(){
    var thirtyMinutesAgo =  CurrentDateTime.getCurrentTimeMinus30MinutesInMilliseconds();
    return   (thirtyMinutesAgo < getDateTime().getTime()) ? 10 : 5;
           }

    public void execute() throws ConfirmReceptionException, MakeTransferException {
             getActionType().getAction().execute( this);


    }

    public void cancel() {
        getUser().substractReputation(20);
        setState(new Cancelled() );

    }

    public void makeTransfer()  throws  MakeTransferException {
        setState(new CVUSent());
        // notify sent

    }

    public Boolean checkTransfer (){
        return  isCVUSent() ;
    }



    public void confirmReception() throws ConfirmReceptionException {

        if (checkTransfer()) {
            getUser().sendCryptoCurrency(getCryptoCurrency(), getCounterPartyUser());
            setState(new CryptoCurrencySent());
            // Finish Transaction

        }
    }

}

