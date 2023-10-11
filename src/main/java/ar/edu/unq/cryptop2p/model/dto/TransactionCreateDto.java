package ar.edu.unq.cryptop2p.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionCreateDto implements Serializable {

    @NotNull
    private int idOption;

    @NotNull
    private Long idCounterParty;


}
