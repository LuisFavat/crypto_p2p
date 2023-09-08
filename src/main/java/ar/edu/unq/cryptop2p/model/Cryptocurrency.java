package ar.edu.unq.cryptop2p.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Cryptocurrency {

    private String name;
    private Double price;
    private final Double percentDown = 0.95;
    private final Double percentUp= 1.05;

    public Cryptocurrency(String name) {
        this.name = name;
    }

    public Cryptocurrency(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public double fivePercentDown() {
        return this.price * percentDown;
    }

    public double fivePercentUp() {
        return this.price * percentUp;
    }

    public boolean intentionPriceInARangeOfFiveUpAndDown(Double intentionPrice) {
        return intentionPrice >= fivePercentDown()  && intentionPrice <= fivePercentUp();
    }

    public boolean OptionPriceHigherThanQuotePrice(Double intentionPrice) {

        return intentionPrice > this.price;
    }

    public boolean OptionPriceLowerThanQuotePrice(Double intentionPrice) {

        return intentionPrice < this.price;
    }


}