package ar.edu.unq.cryptop2p.model.dto;

import ar.edu.unq.cryptop2p.model.UserCrypto;
import lombok.Data;


import java.io.Serializable;

@Data
public class UserRegisterDto implements Serializable {
    private final Long id;
    private final String name;
    private final String surname;
    private final String address;
    private final String email;
    private final String password;
    private final String cvu;
    private final String cryptoAddress;


    public static UserRegisterDto fromModel(UserCrypto user) {
      return new UserRegisterDto(user.getId(),user.getName(),user.getSurname(),user.getAddress(),
              user.getEmail(),user.getPassword(),user.getCvu(),user.getCryptoAddress());
    }

   public  UserCrypto toModel() {
         var user = new UserCrypto(0L, name,  surname,address, email,password, cvu, cryptoAddress);
            user.setNumberOfOperation(0);
            user.setScores(0);
            user.setReputation(0);
            return user;
     }

}