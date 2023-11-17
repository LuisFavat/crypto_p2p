package ar.edu.unq.cryptop2p.model;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.*;

import ar.edu.unq.cryptop2p.model.exceptions.*;
import static  ar.edu.unq.cryptop2p.model.validators.Validator.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

      // @JsonIgnore
       @OneToMany(/*mappedBy = "user",*/cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
       private Set<Option> optioms = new HashSet<>();

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

        @Column
        private int numberOfOperation;

        @Column
        private int scores ;

        @Column
        private int reputation;

        @ManyToMany
        @JoinColumn(name = "id_role")
        private List<Role> roles = new ArrayList<>();


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


    public void validate() throws PreconditionFailedException {
               setName(name);
               setSurname(surname);
               setAddres(address);
               setPassword(password);
               setEmail(email);
               setCvu(cvu);
               setCryptoAddress(cryptoAddress);

     }

    public void setName(String aName) throws PreconditionFailedException {
          if(!validateNameLenght(aName))
          {
            String message =  MessageFormat.format("Not valid name length. Must be between {0} and {1}", minNameLenght(), maxNameLenght());
            response(message, HttpStatus.PRECONDITION_FAILED);
            throw new PreconditionFailedException(message);
         }
        name = aName;
    }

    public void setSurname(String aSurname) throws  PreconditionFailedException {
        String message = MessageFormat.format("Not valid surname length. Must be between {0} and {1}", minLastNameLength(), maxLastNameLength());
        if(!validateLastNameLenght(aSurname)) {
            response(message, HttpStatus.PRECONDITION_FAILED);
            throw new PreconditionFailedException(message);
        }
           surname = aSurname;
    }

    public void setAddres(String aAddress) throws PreconditionFailedException {
        if(!validateAddressLenght(aAddress))
        {   String  message = addressExceptionMessage();
            response(message, HttpStatus.PRECONDITION_FAILED);
            throw new PreconditionFailedException(message);
        }
        address = aAddress;
    }

    public void setEmail(String aEmail) throws PreconditionFailedException {
        if(!validEmail(aEmail))
        {  String message = "Invalid Email Format";
            response(message, HttpStatus.PRECONDITION_FAILED);
            throw new PreconditionFailedException(message);
        }
        email = aEmail;
    }

    public void setPassword(String aPassword) throws PreconditionFailedException {
        validatePassword(aPassword);
        password = aPassword;
    }

    //region cvu
    public void setCvu(String aCvu) throws PreconditionFailedException {
        if(!validateCvuLength(aCvu))
        {    String message = "Invalid CVU format. 22 digits needed.";
            response(message, HttpStatus.PRECONDITION_FAILED);
            throw new PreconditionFailedException(message);
        }
        cvu = aCvu;
    }

    //endregion

    //endregion cryptoAddress
    public void setCryptoAddress(String aCryptoAddress) throws  PreconditionFailedException {
        if(!validateCrytoAddress(aCryptoAddress))
        {   String message = "The crypto address must be 8 digits long.";
            response(message, HttpStatus.PRECONDITION_FAILED);
            throw new PreconditionFailedException(message);
        }
        cryptoAddress = aCryptoAddress;
    }


        public void addOperation()
        {
                numberOfOperation += 1;
        }
        public  void addScore(int givenscores) {scores  += givenscores; }

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

       @Override
       public boolean equals(Object other)
       {
           if(!(other instanceof UserCrypto))
           {
               return false;
           }
           final UserCrypto user = (UserCrypto) other;

           if (!Objects.equals(this.email, user.getEmail()))
           {
               return false;
           }
           return true;
       }

        @Override
        public int hashCode()
        {
            return 9181 * email.hashCode();
        }


   public void acept (Option option , UserCrypto userSelector) throws BadRequestException {
       checkSameUser(option);
       checkUserSelectorChoosedOptionFromUserSession(option, userSelector);
       }


    private void checkSameUser (Option option) throws BadRequestException {
        if ( ! option.getUser().getId().equals(this.getId() ) ) {
            var message =  "userSession must be the owner of the option selected";
            response(message, HttpStatus.BAD_REQUEST);
            throw new BadRequestException(message);
        }
    }

    private void checkUserSelectorChoosedOptionFromUserSession(Option option, UserCrypto userSelector) throws BadRequestException {
        if (! userSelector.getOptioms().contains(option) ) {
            var message =  "Sorry" +  userSelector.getName() + "has not select your option";
            response(message, HttpStatus.BAD_REQUEST);
            throw new BadRequestException(message);
        }
    }


}