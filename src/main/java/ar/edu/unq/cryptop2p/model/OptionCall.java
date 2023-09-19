package ar.edu.unq.cryptop2p.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OptionCall extends Option {


    public OptionCall(CryptoCurrency cryptocurrency, Double price, float units, UserCrypto user){
            super(cryptocurrency, price, units, user);
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
