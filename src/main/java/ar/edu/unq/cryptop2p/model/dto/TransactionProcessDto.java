package ar.edu.unq.cryptop2p.model.dto;

import ar.edu.unq.cryptop2p.helpers.ActionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class TransactionProcessDto implements Serializable {

    @NotNull
    private int idTransaction;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ActionType actionType;


}
