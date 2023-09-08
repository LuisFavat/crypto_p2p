package ar.edu.unq.cryptop2p.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public abstract class Option {


    private Cryptocurrency cryptocurrency;

    private float units;

    private Double price;

    protected UserCrypto user;

    //protected String address;


    public Option(Cryptocurrency cryptocurrency, Double price, float units, UserCrypto user) {
        this.cryptocurrency = cryptocurrency;
        this.price = price;
        this.units = units;
        this.user = user;
    }


    public Double amountPriceInPesos() {
        return this.price * this.units;
    }

    public abstract String getAddress();

    public Double quote()
    {
        return cryptocurrency.getPrice();
    }

    public String nameOfTheOwner()
    {
        return user.getName() + " " +user.getSurname();
    }

    public int numberOfOperation()
    {
        return user.getNumberOfOperation();
    }

    public int reputation()
    {
        return user.getReputation();
    }

}