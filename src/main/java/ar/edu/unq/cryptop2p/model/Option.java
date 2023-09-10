package ar.edu.unq.cryptop2p.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@NoArgsConstructor
@Getter
@Setter

public abstract class Option {


    private int id;


    private Cryptocurrency cryptocurrency;

<<<<<<< HEAD

    private int units;
=======
    private float units;
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733


    private Double price;

<<<<<<< HEAD

    private UserCrypto user;
=======
    protected UserCrypto user;
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733



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