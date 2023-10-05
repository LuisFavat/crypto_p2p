package ar.edu.unq.cryptop2p.model.dto;

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
public class TransactionCreateDto implements Serializable {

    @NotNull
    private int idOption;
}
