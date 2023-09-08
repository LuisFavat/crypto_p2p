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

    public Cryptocurrency(String name) {
        this.name = name;
    }

    public Cryptocurrency(String name, double price) {
        this.name = name;
        this.price = price;
    }


}