package ar.edu.unq.cryptop2p.helpers;

import ar.edu.unq.cryptop2p.builders.OptionBuilder;
import ar.edu.unq.cryptop2p.builders.OptionCallBuilder;
import ar.edu.unq.cryptop2p.builders.OptionPutBuilder;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.OptionCall;
import ar.edu.unq.cryptop2p.model.OptionPut;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDTO;
import jakarta.annotation.PostConstruct;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class OptionProvider {

    private final LinkedList<OptionBuilder>options = new LinkedList<>();

    @PostConstruct
    private  void init(){
       options.add( OptionCallBuilder.anOption() );
       options.add( OptionPutBuilder.anOption() );

    }

   public  Option provide (OptionPostDTO optionDTO){
    OptionBuilder amOption =  options.stream().filter(  option -> option.getTyoe() == optionDTO.getType()  ).findFirst().get();
   return  amOption
           .withUser(optionDTO.getUser())
           .withCryptoCurrency(optionDTO.getCryptocurrency())
           .withPrice(optionDTO.getPrice())
           .withCryptoAmount(optionDTO.getCryptoAmount())
           .build();

    }
}
