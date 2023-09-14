package ar.edu.unq.cryptop2p.model;

import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;

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

    public int reputation() {
        return option.reputation();
    }

    public String address() {
        return option.getAddress();
    }

    public void execute() {
        state.execute(getAction(), this);
    }

    public boolean isDifferencePrice(double optionPrice) {
        return getCryptoCurrency().isDifferencePrice(optionPrice);
    }

    public void cancel() {
        setState(new Cancelled());
    }

    public void makeTransfer() {
        setState(new CVUSent());
        getCounterPartyUser().moneyTransfer(getAddress(), getBank());
        // notify sent
    }

    public void confirmReception () {
        setState(new CryptoCurrencySent());
        if (getUser().checkTransfer()) {
            getUser().sendCryptoCurrency(getCryptoCurrency(), getCounterPartyUser());
            // Finish Transaction
        }
    }
}

