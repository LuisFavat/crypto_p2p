package ar.edu.unq.cryptop2p.model;


import java.io.Serializable;
import java.text.MessageFormat;
import java.util.*;

import ar.edu.unq.cryptop2p.model.exceptions.*;
import ar.edu.unq.cryptop2p.model.validators.Validator;
import jakarta.persistence.*;
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

       @Column(nullable = false)
       private String name;

        @Column(nullable = false)
        private String surname;

        @Column(nullable = false)
        private  String address ;

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


       @Transient
       private LinkedList<CryptoCurrency> cryptoCurrencies;


        @Transient
        private  Validator  validator = new Validator();


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
        ) throws Exception {
        this.id= id;
        setName(name);
        setSurame(surname);
        setAddres(address);
        setEmail(email);
        setPassword(password);
        setCvu(cvu);
        setCryptoAddress(cryptoAddress);
                }

    public void setName(String aName) throws UserNameException {
        if(!validator.validateNameLenght(aName))
        {
            throw new UserNameException( MessageFormat.format("Not valid name length. Must be between {0} and {1}", validator.minNameLenght(), validator.maxNameLenght()));
        }
        name = aName;
    }

    public String getName()
    {
        return name;
    }

    public void setSurame(String aSurname) throws UserNameException
    {
        if(!validator.validateLastNameLenght(aSurname))
            throw new UserNameException(MessageFormat.format("Not valid name length. Must be between {0} and {1}", validator.minLastNameLength(), validator.maxLastNameLength()));
        surname = aSurname;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setAddres(String aAddress) throws AddressException
    {
        if(!validator.validateAddressLenght(aAddress))
        {
            throw new AddressException(validator.addressExceptionMessage());
        }
        address = aAddress;
    }

    public String getAddress()
    {
        return address;
    }

    public void setEmail(String aEmail) throws EmailException
    {
        if(!validator.validEmail(aEmail))
        {
            throw new EmailException("Invalid Email Format");
        }
        email = aEmail;
    }

    public String getEmail()
    {
        return email;
    }

    public void setPassword(String aPassword) throws PasswordException
    {
        if(!validator.validatePassword(aPassword))
        {
            throw new PasswordException(validator.getPasswordExpetionMessage());
        }
        password = aPassword;
    }

    public String getPassword()
    {
        return password;
    }

    //region cvu
    public void setCvu(String aCvu) throws Exception
    {
        if(!validator.validateCvuLength(aCvu))
        {
            throw new CvuException("Invalid CVU format. 22 digits needed.");
        }
        cvu = aCvu;
    }

    public String getCvu()
    {
        return cvu;
    }
    //endregion

    //endregion cryptoAddress
    public void setCryptoAddress(String aCryptoAddress) throws CryptoAddressException
    {
        if(!validator.validateCrytoAddress(aCryptoAddress))
        {
            throw new CryptoAddressException("The crypto address must be 8 digits long.");
        }
        cryptoAddress = aCryptoAddress;
    }

    public String getCryptoAddress()
    {
        return cryptoAddress;
    }

        public int getNumberOfOperation()
        {
                return numberOfOperation;
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



      public void sendCryptoCurrency(CryptoCurrency cryptoCurrency, UserCrypto user){
               user.getCryptoCurrencies().add(cryptoCurrency);
     }
}
