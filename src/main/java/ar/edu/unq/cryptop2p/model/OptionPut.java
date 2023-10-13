package ar.edu.unq.cryptop2p.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "options_put")
@PrimaryKeyJoinColumn(name = "id_options")
public class OptionPut  extends Option {


    public OptionPut(CryptoCurrency cryptocurrency, Double price, float cryptoAmount, UserCrypto user) {
        super(cryptocurrency, price, cryptoAmount, user);
    }

    public String virtualAddress() {
        return user.getCvu();
    }


    public boolean IsValidPriceToPost() {
        return OptionPriceLowerThanQuotePrice();
    }

    public boolean OptionPriceLowerThanQuotePrice() {

        return this.getPrice() < this.quote();
    }
}