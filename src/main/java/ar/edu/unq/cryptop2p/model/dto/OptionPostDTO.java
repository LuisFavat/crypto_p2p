package ar.edu.unq.cryptop2p.model.dto;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class OptionPostDTO {
    private OptionType type;
    private CryptoCurrency cryptocurrency;
    private Double price;
    private int cryptoAmount;
    private UserCrypto user;
}
