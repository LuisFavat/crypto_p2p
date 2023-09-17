package ar.edu.unq.cryptop2p.helpers;

import ar.edu.unq.cryptop2p.model.*;
import lombok.Getter;

@Getter

public enum  OptionType {
   OPTIONCALL (new OptionCall() ) ,
   OPTIONPUT (new OptionPut()) ;

   private Option option;

  private  OptionType ( Option option  ) {

   }

}