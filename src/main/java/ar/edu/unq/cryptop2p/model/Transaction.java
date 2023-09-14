package ar.edu.unq.cryptop2p.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}

