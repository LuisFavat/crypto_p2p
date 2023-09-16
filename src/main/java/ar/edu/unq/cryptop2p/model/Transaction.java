package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor

public class Transaction {

    private Option option;
    private State state;
    private Action action;
    private UserCrypto counterPartyUser;


    public Transaction(Option aOption) {
        option = aOption;
    }

    public Bank getBank() {
        return getUser().getBank();
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

    private boolean isCanceled(){
          return  (state.getClass().getName().equals(Cancelled.class.getName()));
        }

    public void addScoresToUsers(int scores){
        getUser().addScore(scores);
        getCounterPartyUser().addScore(scores);
    }


    private int gainScores(){
    var thirtyMinutesAgo =  CurrentDateTime.getCurrentTimeMinus30MinutesInMilliseconds();
    return   (thirtyMinutesAgo < getDateTime().getTime()) ? 10 : 5;
           }


}

