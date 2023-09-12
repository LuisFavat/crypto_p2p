package ar.edu.unq.cryptop2p.helpers;

import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDTO;
import org.jetbrains.annotations.NotNull;

public class OptionProvider {
    @NotNull
   public static  Option provide (@NotNull OptionPostDTO optionDTO){
     var  anOption =   optionDTO.getType().getOption();
     anOption.setPrice(optionDTO.getPrice());
     anOption.setUser(optionDTO.getUser());;
     anOption.setCryptocurrency(optionDTO.getCryptocurrency());
     anOption.setCryptoAmount(optionDTO.getCryptoAmount());
     return anOption;

    }
}
