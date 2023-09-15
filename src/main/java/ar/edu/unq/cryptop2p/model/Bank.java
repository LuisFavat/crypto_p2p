package ar.edu.unq.cryptop2p.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Setter
@Getter
public class Bank {
    private LinkedList<String> moneyTransfers = new LinkedList<>();

    public Bank(){
        this.setMoneyTransfers(moneyTransfers); ;
    }
}
