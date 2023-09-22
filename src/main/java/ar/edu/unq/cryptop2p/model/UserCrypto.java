package ar.edu.unq.cryptop2p.model;

import java.io.Serializable;
import java.text.MessageFormat;
import ar.edu.unq.cryptop2p.model.exceptions.*;
import static  ar.edu.unq.cryptop2p.model.validators.Validator.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "userCrypto")
public class UserCrypto implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_userCrypto")
        private Long id;

      @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
       @Column(nullable = false)
       private String name;

        @Column(nullable = false)
        private String surname;

        @Column(nullable = false)
        private  String address ;

      @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+*=])(?=\\S+$).{6,}$", message = "Password must contain at " +
           "least 1 lowercase, 1 uppercase, 1 special character, and at least 6 characters")
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



        public UserCrypto() {
        }


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

    public void setName(String aName) throws UserNameException {
        if(! validateNameLenght(aName))
        {
            throw new UserNameException( MessageFormat.format("Not valid name length. Must be between {0} and {1}", minNameLenght(), maxNameLenght()));
        }
        name = aName;
    }

    public void setSurame(String aSurname) throws UserNameException
    {
        if(!validateLastNameLenght(aSurname))
            throw new UserNameException(MessageFormat.format("Not valid name length. Must be between {0} and {1}", minLastNameLength(), maxLastNameLength()));
        surname = aSurname;
    }

    public void setAddres(String aAddress) throws AddressException
    {
        if(!validateAddressLenght(aAddress))
        {
            throw new AddressException(addressExceptionMessage());
        }
        address = aAddress;
    }

    public void setEmail(String aEmail) throws EmailException
    {
        if(!validEmail(aEmail))
        {
            throw new EmailException("Invalid Email Format");
        }
        email = aEmail;
    }

    public void setPassword(String aPassword) throws PasswordException
    {
        if(!validatePassword(aPassword))
        {
            throw new PasswordException(getPasswordExpetionMessage());
        }
        password = aPassword;
    }

    //region cvu
    public void setCvu(String aCvu) throws CvuException
    {
        if(!validateCvuLength(aCvu))
        {
            throw new CvuException("Invalid CVU format. 22 digits needed.");
        }
        cvu = aCvu;
    }

    //endregion

    //endregion cryptoAddress
    public void setCryptoAddress(String aCryptoAddress) throws CryptoAddressException
    {
        if(validateCrytoAddress(aCryptoAddress))
        {
            throw new CryptoAddressException("The crypto address must be 8 digits long.");
        }
        cryptoAddress = aCryptoAddress;
    }

        //TODO test
        public void addOperation()
        {
                numberOfOperation += 1;
        }
        public  void addScore(int givenscores) {scores += givenscores; }

        public void setNumberOfOperation(int aNumberOfOperations)
        {
                numberOfOperation = aNumberOfOperations;
        }

        public void setReputation(int aReputation)
        {
                reputation = aReputation;
        }

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
