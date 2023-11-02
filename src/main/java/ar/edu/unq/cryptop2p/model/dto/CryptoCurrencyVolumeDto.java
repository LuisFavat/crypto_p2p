package ar.edu.unq.cryptop2p.model.dto;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class CryptoCurrencyVolumeDto implements  Serializable {
    String cryptoName;
    Double criptoNominalAmounty;
    Double currentQuote;
    Double  amountPriceInPesos;

}
