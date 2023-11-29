package ar.edu.unq.cryptop2p.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginDto implements Serializable {
    private final String email;
    private final String password;


}
