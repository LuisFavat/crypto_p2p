package ar.edu.unq.cryptop2p.helpers;

import ar.edu.unq.cryptop2p.model.*;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;
import java.util.Arrays;

import static ar.edu.unq.cryptop2p.helpers.OptionType.OPTIONPUT;
import static ar.edu.unq.cryptop2p.model.validators.Validator.*;

public class OptionProvider {

   public static @NotNull Option provide (@NotNull OptionPostDto optionPostDto, UserCrypto user, CryptoCurrency crypto) throws BadRequestException{
      Option option;
       checkValidOperation(optionPostDto.getOperation());

       if (optionPostDto.getOperation().equals(OPTIONPUT)) {
           option = new OptionPut(crypto, optionPostDto.getPrice(), optionPostDto.getCryptoAmount(), user);
       }
       else {
           option = new OptionCall(crypto, optionPostDto.getPrice(), optionPostDto.getCryptoAmount(), user);}
       option.setOperation(optionPostDto.getOperation());
       return option;
    /*
    var  anOption =   optionPostDTO.getOperation().getOption();
    anOption.setOperation(optionPostDTO.getOperation());
    anOption.setPrice(optionPostDTO.getPrice());
    anOption.setUser(user);
    anOption.setCryptocurrency(crypto);
    anOption.setCryptoAmount(optionPostDTO.getCryptoAmount());
    anOption.setDateTime(CurrentDateTime.getNewDate());
    return anOption;
*/
    }

  public static  void  checkValidOperation(OptionType operation) throws  BadRequestException {
    if ( ! hasValidOperation(operation)) {
     var message = MessageFormat.format("Sorry, {0} is not a valid operation, please operations must be: {1} only ",operation,Arrays.toString(OptionType.values()));
     response(message, HttpStatus.BAD_REQUEST);
    throw new BadRequestException(message);
    }

  }

  public static  boolean  hasValidOperation(OptionType operation){
       return  (Arrays.stream(OptionType.values()).toList()).contains(operation);
  }

}
