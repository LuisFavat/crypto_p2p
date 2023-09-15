package ar.edu.unq.cryptop2p.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OptionCall extends Option {


    public OptionCall(CryptoCurrency cryptocurrency, Double price, float units, UserCrypto user){
            super(cryptocurrency, price, units, user);
            //address = user.getCryptoAddress();
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
