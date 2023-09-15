package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.model.Bank;
import java.util.LinkedList;

public class BankBuilder {
    private LinkedList<String> moneyTransfers = new LinkedList<>();

    public static BankBuilder aBank() {return new BankBuilder(); }


    public  BankBuilder withMoneyTransfers (LinkedList<String> transfers)
    {
        moneyTransfers = transfers;
        return this;
    }

    public Bank build()
    {
       Bank bank = new Bank();
        return bank;
    }
}
