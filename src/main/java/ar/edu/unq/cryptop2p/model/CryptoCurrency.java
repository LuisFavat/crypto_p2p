package ar.edu.unq.cryptop2p.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id_cryptocurrency", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String dateTime;

    @JsonIgnore
    @Transient
    private final Double percentDown = 0.95;

    @JsonIgnore
    @Transient
    private final Double percentUp= 1.05;


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