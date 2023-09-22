package ar.edu.unq.cryptop2p.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserCryptoDto implements Serializable {
    private final Long id;
    private final String name;
    private final String surname;
    private final String address;
    private final String email;
    private final String cvu;
    private final String cryptoAddress;
    private final int numberOfOperation;
    private final int scores;
    private final int reputation;
}
