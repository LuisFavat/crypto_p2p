package ar.edu.unq.cryptop2p.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class OptionCall extends Option {


    public OptionCall(CryptoCurrency cryptocurrency, Double price, float cryptoAmount, UserCrypto user){
            super(cryptocurrency, price, cryptoAmount, user);
        }

        public String getVirtualAddress ()
        {
            return user.getCryptoAddress();
         }

    public  boolean  IsValidPriceToPost(){
        return OptionPriceHigherThanQuotePrice();
    }

    private boolean OptionPriceHigherThanQuotePrice() {

        return this.getPrice() > this.quote();
    }

    }
