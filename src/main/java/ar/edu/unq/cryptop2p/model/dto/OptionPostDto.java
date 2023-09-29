package ar.edu.unq.cryptop2p.model.dto;

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

import static ar.edu.unq.cryptop2p.helpers.OptionProvider.*;

@Getter
@Setter
@AllArgsConstructor
@Data

public class OptionPostDto implements Serializable {
    @NotNull
    @Enumerated(EnumType.STRING)
    private OptionType type;

    @NotNull
    private String cryptoCurrencyName;

    @NotNull
    @Min(value = 0)
    private Double price;

    @NotNull
    @Min(value = 0)
    private float cryptoAmount;

    @NotNull
    private Long userId;

}
