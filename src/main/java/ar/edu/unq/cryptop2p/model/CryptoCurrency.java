package ar.edu.unq.cryptop2p.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cryptocurrency")
public class CryptoCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cryptocurrency")

    private String name;
    private Double price;
    private final Double percentDown = 0.95;
    private final Double percentUp= 1.05;
    private String dateTime;

    public CryptoCurrency(String name) {
        this.name = name;
    }

    public CryptoCurrency(String name, double price) {
        this.name = name;
        this.price = price;

    }


    public double fivePercentDown() {
        return this.price * percentDown;
    }

    public double fivePercentUp() {
        return this.price * percentUp;
    }






}