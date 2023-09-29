package ar.edu.unq.cryptop2p.model.dto;

import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Data
public class OptionViewDto implements Serializable {

   @NotNull
   @Enumerated(EnumType.STRING)
    private  OptionType operation;

    @NotNull
    private  String cryptoCurrencyName;

    @NotNull
    private String nameOfTheOwner;

   @NotNull
   @Min(value = 0)
    private  Double price;

   @NotNull
   private float cryptoAmount;

    @NotNull
    private   Double amountPriceInPesos;

   @NotNull
    private int numberOfOperation;

   @NotNull
    private  float reputation;



    public static OptionViewDto fromModel (Option option){
       return new OptionViewDto (option.getOperation(), option.getCryptocurrency().getName(), option.nameOfTheOwner(), option.getPrice(), option.getCryptoAmount(), option.amountPriceInPesos(), option.numberOfOperation(),option.reputation());
   }


}
