package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import static ar.edu.unq.cryptop2p.model.validators.Validator.response;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "options")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Option implements  Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @Column(name = "id_options")
    protected int id;

    @Column(nullable = false)
    protected OptionType operation;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_cryptocurrency", referencedColumnName = "id_cryptocurrency")
    protected CryptoCurrency cryptocurrency;

    @NotNull
    @Min(value = 0)
    @Column(nullable = false)
    protected float cryptoAmount;

    @NotNull
    @Min(value = 0)
    @Column(nullable = false)
    protected Double price;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_userCrypto", referencedColumnName = "id_userCrypto")
    protected UserCrypto user;


    @Column
    @DateTimeFormat
    protected Date dateTime;

    @Column
    protected int numberOfOperation ;

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

    public abstract String virtualAddress();

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

    public int scores()
    {
        return user.getScores();
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


    public  void  checkOptionPrice() throws  BadRequestException {
        if (!validateOptionPriceInARangeOfFiveUpAndDown()) {
            var message = "You cannot post, the option Price" +
                    getPrice() + " is outside the reference price" + quote();
            response(message, HttpStatus.EXPECTATION_FAILED);
            throw new BadRequestException(message);
        }
    }

    public void checkNotSameUser(UserCrypto userCounterParty) throws BadRequestException {
        if (getUser().getId().equals(userCounterParty.getId())) {
            var message = "The counterparty cannot be the owner of the option";
            response(message, HttpStatus.BAD_REQUEST);
            throw new BadRequestException(message);
        }
    }


    public void checkSelectedByCounterParty(UserCrypto userCounterParty) throws BadRequestException {
        if (! userCounterParty.getOptioms().contains(this)) {
            var message = "You can not acept, The counterparty has not selected this option";
            response(message, HttpStatus.BAD_REQUEST);
            throw new BadRequestException(message);
        }
    }

    public abstract boolean  IsValidPriceToPost();


}