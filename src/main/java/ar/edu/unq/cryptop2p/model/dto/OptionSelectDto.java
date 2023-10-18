package ar.edu.unq.cryptop2p.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Data
public class OptionSelectDto implements Serializable {

    @NotNull
    private int idOption;

    @NotNull
    private Long idCounterParty;

    public OptionSelectDto(int idAnOption, Long idUser) {
        this.idOption = idAnOption;
        this.idCounterParty = idUser;
    }
}
