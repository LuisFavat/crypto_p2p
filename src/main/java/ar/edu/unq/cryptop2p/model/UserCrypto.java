package ar.edu.unq.cryptop2p.model;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import ar.edu.unq.cryptop2p.model.exceptions.*;
import static  ar.edu.unq.cryptop2p.model.validators.Validator.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "userCrypto")
public class UserCrypto implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_userCrypto")
        private Long id;

       @Column(nullable = false)
       private String name;

        @Column(nullable = false)
        private String surname;

        @Column(nullable = false)
        private  String address ;
      
        @Column(nullable = false)
        private String password;

        @Column(nullable = false, unique = true)
        private  String  email;

        @Column
        private String cvu ;

        @Column
        private String cryptoAddress ;

        private int numberOfOperation;
        private int scores;
        private int reputation;


        public UserCrypto(
                Long id,
                String name,
                String surname,
                String address,
                String password,
                String email,
                String cvu,
                String cryptoAddress
                    ) {
       this.id= id;
       this.name = name;
       this.surname = surname;
       this.address = address;
       this.email= email;
       this.password= password;
       this.cvu = cvu;
       this.cryptoAddress= cryptoAddress;


                }


    public void validate() throws InvalidUserException {
               setName(name);
               setSurname(surname);
               setAddres(address);
               setPassword(password);
               setEmail(email);
               setCvu(cvu);
               setCryptoAddress(cryptoAddress);

     }

    public void setName(String aName) throws InvalidUserException {
          if(!validateNameLenght(aName))
          {
            String message =  MessageFormat.format("Not valid name length. Must be between {0} and {1}", minNameLenght(), maxNameLenght());
            badRequestResponse(message);
            throw new InvalidUserException(message);
         }
        name = aName;
    }

    public void setSurname(String aSurname) throws InvalidUserException
    {
        String message = MessageFormat.format("Not valid surname length. Must be between {0} and {1}", minLastNameLength(), maxLastNameLength());
        if(!validateLastNameLenght(aSurname)) {
            badRequestResponse(message);
            throw new InvalidUserException(message);
        }
           surname = aSurname;
    }

    public void setAddres(String aAddress) throws InvalidUserException
    {
        if(!validateAddressLenght(aAddress))
        {   String  message = addressExceptionMessage();
            badRequestResponse(message);
            throw new InvalidUserException(message);
        }
        address = aAddress;
    }

    public void setEmail(String aEmail) throws InvalidUserException
    {
        if(!validEmail(aEmail))
        {  String message = "Invalid Email Format";
            badRequestResponse(message);
            throw new InvalidUserException(message);
        }
        email = aEmail;
    }

    public void setPassword(String aPassword) throws InvalidUserException
    {
        validatePassword(aPassword);
        password = aPassword;
    }

    //region cvu
    public void setCvu(String aCvu) throws InvalidUserException
    {
        if(!validateCvuLength(aCvu))
        {    String message = "Invalid CVU format. 22 digits needed.";
            badRequestResponse(message);
            throw new InvalidUserException(message);
        }
        cvu = aCvu;
    }

    //endregion

    //endregion cryptoAddress
    public void setCryptoAddress(String aCryptoAddress) throws InvalidUserException
    {
        if(!validateCrytoAddress(aCryptoAddress))
        {   String message = "The crypto address must be 8 digits long.";
            badRequestResponse(message);
            throw new InvalidUserException(message);
        }
        cryptoAddress = aCryptoAddress;
    }


        public void addOperation()
        {
                numberOfOperation += 1;
        }
        public  void addScore(int givenscores) {scores += givenscores; }

       public int reputation()  {
            if (numberOfOperation <= 0) {
               reputation = scores;
            }
            else {
              reputation =  (scores / numberOfOperation);
               }
            return  reputation;
        }

        public  void substractReputation(int takenscores) {
           scores -= takenscores;
           if (scores < 0) {
               scores = 0;
           }
       }


}