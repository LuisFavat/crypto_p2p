package ar.edu.unq.cryptop2p.model.dto;

import jakarta.validation.constraints.NotNull;

public class OptionSelectDto {

    @NotNull
    private int idOption;

    @NotNull
    private Long idUser;

}
