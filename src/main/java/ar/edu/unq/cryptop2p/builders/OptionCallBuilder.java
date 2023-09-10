package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.Cryptocurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.OptionCall;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class OptionCallBuilder extends OptionBuilder{

    private Cryptocurrency criptocurrency;
    private UserCrypto user;
    private int units= 0;
    private double price= 0.00;
    private OptionType tyoe = OptionType.OPTIONCALL;

   public static OptionCallBuilder anOption() { return new OptionCallBuilder(); }

  public Option build ()  { return new OptionCall(criptocurrency,  price,  units, user);}
}
