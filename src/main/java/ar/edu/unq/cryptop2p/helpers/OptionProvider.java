package ar.edu.unq.cryptop2p.helpers;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.exceptions.InvalidResourceException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static ar.edu.unq.cryptop2p.model.validators.Validator.*;

public class OptionProvider {

   public static  Option provide (OptionPostDto optionPostDTO, UserCrypto user, CryptoCurrency crypto) throws InvalidResourceException {
    checkValidOperation(optionPostDTO.getOperation());
    var  anOption =   optionPostDTO.getOperation().getOption();
    anOption.setOperation(optionPostDTO.getOperation());
    anOption.setPrice(optionPostDTO.getPrice());
    anOption.setUser(user);
    anOption.setCryptocurrency(crypto);
    anOption.setCryptoAmount(optionPostDTO.getCryptoAmount());
    anOption.setDateTime(CurrentDateTime.getNewDate());
     return anOption;

    }

  public static  void  checkValidOperation(OptionType operation) throws InvalidResourceException {
    if ( ! hasValidOperation(operation)) {
     var message = "Sorry, this option has not a valid operation, please operations must be :" + Arrays.toString(OptionType.values()) + "only";
     response(message, HttpStatus.METHOD_NOT_ALLOWED);
    throw new InvalidResourceException(message);
    }

  }

  public static  boolean  hasValidOperation(OptionType operation){
       return  Arrays.stream(OptionType.values()).toList().contains(operation);
  }

}
