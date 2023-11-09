package ar.edu.unq.cryptop2p.model.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoAmountDto
{
    int amount;
    String cryptoName;
}
