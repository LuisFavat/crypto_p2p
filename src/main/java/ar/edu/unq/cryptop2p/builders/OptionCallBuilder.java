package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.OptionCall;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


@Getter
@Setter
@NoArgsConstructor
public class OptionCallBuilder  extends OptionBuilder  {


    private OptionType tyoe = OptionType.OPTIONCALL;

    @NotNull
    @Contract(" -> new")
   public static  OptionCallBuilder anOption() { return new OptionCallBuilder(); }



    public Option build ()  { return new OptionCall(this.getCriptocurrency(), this.getPrice() , this.getCryptoAmount(), this.getUser());}
}
