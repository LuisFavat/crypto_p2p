package ar.edu.unq.cryptop2p.helpers;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;



public class OptionProvider {

   public static  Option provide (OptionPostDto optionPostDTO, UserCrypto user, CryptoCurrency crypto) {
    var  anOption =   optionPostDTO.getType().getOption();
    anOption.setType(optionPostDTO.getType());
    anOption.setPrice(optionPostDTO.getPrice());
    anOption.setUser(user);
    anOption.setCryptocurrency(crypto);
    anOption.setCryptoAmount(optionPostDTO.getCryptoAmount());
    anOption.setDateTime(CurrentDateTime.getNewDate());
    return anOption;

    }
}
