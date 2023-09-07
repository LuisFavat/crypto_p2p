package ar.edu.unq.cryptop2p.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public abstract class Option {


    private Cryptocurrency cryptocurrency;

    private int units;

    private Double price;

    private UserCrypto user;


    public Option(Cryptocurrency cryptocurrency, Double price, int units, UserCrypto user) {
        this.cryptocurrency = cryptocurrency;
        this.price = price;
        this.units = units;
        this.user = user;
    }


    public Double amountPriceInPesos() {
        return this.price * this.units;
    }

}