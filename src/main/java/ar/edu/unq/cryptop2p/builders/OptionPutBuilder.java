package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Contract;

@Getter
@Setter
@NoArgsConstructor
public class OptionPutBuilder extends OptionBuilder {


    //private Cryptocurrency criptocurrency;
    //private UserCrypto user;
    //private int units = 0 ;
    //private  double price = 0.00;
    //private OptionType tyoe = OptionType.OPTIONPUT;

    @NotNull
    @Contract(" -> new")
    public static OptionPutBuilder anOption() { return new OptionPutBuilder(); }

    public Option build()  { return new OptionPut(this.getCriptocurrency(), this.getPrice() , this.getCryptoAmount(), this.getUser());}
}
