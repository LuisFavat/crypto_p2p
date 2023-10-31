package ar.edu.unq.cryptop2p.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CryptoCurrencyLastQuoteListDto implements Serializable {

  List<CryptoCurrencyLastQuoteDto> cryptoCurrencyLastQuoteList ;
}
