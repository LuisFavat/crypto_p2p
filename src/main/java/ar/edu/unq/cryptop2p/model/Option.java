package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.exceptions.PriceNotInAValidRangeException;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import java.util.Date;

import static ar.edu.unq.cryptop2p.model.validators.Validator.response;


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


    @Column(nullable = false)
    private OptionType operation;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_cryptocurrency", referencedColumnName = "id_cryptocurrency")
    private CryptoCurrency cryptocurrency;

    @NotNull
    @Min(value = 0)
    @Column(nullable = false)
    private float cryptoAmount;

    @NotNull
    @Min(value = 0)
    @Column(nullable = false)
    private Double price;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_userCrypto", referencedColumnName = "id_userCrypto")
    protected UserCrypto user;


    @Column
    @DateTimeFormat
    private Date dateTime;

   @Column
   protected int numberOfOperation;

    @Column
    protected float reputation;

    @Transient
    protected int scores;


    protected Option(CryptoCurrency cryptocurrency, Double price, float cryptoAmount, UserCrypto user) {
        this.cryptocurrency = cryptocurrency;
        this.price = price;
        this.cryptoAmount = cryptoAmount;
        this.user = user;
        this.dateTime =  CurrentDateTime.getNewDate();
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
        return user.reputation();
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

    public  void  checkOptionPrice() throws PriceNotInAValidRangeException {
        if (!validateOptionPriceInARangeOfFiveUpAndDown()) {
            var message = "You cannot post, the option Price" +
                    getPrice() + " is outside the reference price" + quote();
            response(message, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
            //InvalidRangeRequestResponse(message);
            throw new PriceNotInAValidRangeException(message);
        }
    }

    public abstract boolean  IsValidPriceToPost();


}