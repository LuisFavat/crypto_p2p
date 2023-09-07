package ar.edu.unq.cryptop2p.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cryptocurrency {

    private String name;
    private Double price;

    public Cryptocurrency(String name) {
        this.name = name;
    }

    public Cryptocurrency(String name, double price) {
        this.name = name;
        this.price = price;
    }


}