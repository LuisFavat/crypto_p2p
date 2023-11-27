package ar.edu.unq.cryptop2p.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor

//@Table(name = "options_call")
@PrimaryKeyJoinColumn(name = "id_options")
public class OptionCall extends Option {



   public OptionCall(CryptoCurrency cryptocurrency, Double price, float cryptoAmount, UserCrypto user){
            super(cryptocurrency, price, cryptoAmount, user);
        }

   public String virtualAddress ()
        {
            return user.getCryptoAddress();
         }

   public  boolean  IsValidPriceToPost(){
        return OptionPriceHigherThanQuotePrice();
    }

   private boolean OptionPriceHigherThanQuotePrice() {

        return this.getPrice() >= this.quote();
    }

}
