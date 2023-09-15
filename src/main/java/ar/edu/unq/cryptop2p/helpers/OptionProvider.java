package ar.edu.unq.cryptop2p.helpers;

import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDTO;
import org.jetbrains.annotations.NotNull;

public class OptionProvider {
    @NotNull
   public static  Option provide (@NotNull OptionPostDTO optionPostDTO){
     var  anOption =   optionPostDTO.getType().getOption();
     anOption.setPrice(optionPostDTO.getPrice());
     anOption.setUser(optionPostDTO.getUser());
     anOption.setCryptocurrency(optionPostDTO.getCryptocurrency());
     anOption.setCryptoAmount(optionPostDTO.getCryptoAmount());
     return anOption;

    }
}
