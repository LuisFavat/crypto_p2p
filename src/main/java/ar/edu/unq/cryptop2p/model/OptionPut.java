package ar.edu.unq.cryptop2p.model;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OptionPut  extends Option {

    public OptionPut(CryptoCurrency cryptocurrency, Double price, float cryptoAmount, UserCrypto user) {
        super(cryptocurrency, price, cryptoAmount, user);
    }

    public String getVirtualAddress() {
        return user.getCvu();
    }


    public boolean IsValidPriceToPost() {
        return OptionPriceLowerThanQuotePrice();
    }

    public boolean OptionPriceLowerThanQuotePrice() {

        return this.getPrice() < this.quote();
    }
}