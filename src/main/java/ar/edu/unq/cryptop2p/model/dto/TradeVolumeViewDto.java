package ar.edu.unq.cryptop2p.model.dto;


import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TradeVolumeViewDto implements Serializable {
     Date requestDate ;
     //Double totalValueTradedInDolars;
     Double totalValueTradedInPesos;
     List<CryptoCurrencyVolumeDto> cryptoCurrencyList ;
}
