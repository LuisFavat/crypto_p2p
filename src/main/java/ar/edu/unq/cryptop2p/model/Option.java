package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "options")

public abstract class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_options")
    private int id;

    @Transient
    private CryptoCurrency cryptocurrency;

    @Column(nullable = false)
    private float cryptoAmount;

    @Column(nullable = false)
    private Double price;

    @Transient
    protected UserCrypto user;

    @Transient
    protected Date dateTime;

    @Transient
    protected float reputation;

    @Transient
    protected int scores;


    public Option(CryptoCurrency cryptocurrency, Double price, float cryptoAmount, UserCrypto user) {
        this.cryptocurrency = cryptocurrency;
        this.price = price;
        this.cryptoAmount = cryptoAmount;
        this.user = user;
        this.dateTime = CurrentDateTime.getNewDate();
    }


    public Double amountPriceInPesos() {
        return this.price * this.cryptoAmount;
    }

    public abstract String getVirtualAddress();

    public String getAddress() {return user.getAddress();};

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

    public float reputation()
    {
        return user.getReputation();
    }

    public boolean validateOptionPriceInARangeOfFiveUpAndDown() {
        return optionPriceHigherOrEqualThanfivePercentDown()
                && optionPriceLowerOrEqualThanPercentUp();
    }


    public boolean optionPriceHigherOrEqualThanfivePercentDown() {

        return this.getPrice() >= this.getCryptocurrency().fivePercentDown() ;
    }

    public boolean optionPriceLowerOrEqualThanPercentUp() {

        return this.getPrice() <= this.getCryptocurrency().fivePercentUp();
    }

    public abstract boolean  IsValidPriceToPost();


}