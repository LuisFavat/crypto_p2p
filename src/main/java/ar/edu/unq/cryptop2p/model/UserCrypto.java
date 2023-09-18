package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.validators.Validator;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.*;

import ar.edu.unq.cryptop2p.model.exceptions.AddressException;
import ar.edu.unq.cryptop2p.model.exceptions.CryptoAddressException;
import ar.edu.unq.cryptop2p.model.exceptions.CvuException;
import ar.edu.unq.cryptop2p.model.exceptions.EmailException;
import ar.edu.unq.cryptop2p.model.exceptions.InvalidReputationException;
import ar.edu.unq.cryptop2p.model.exceptions.PasswordException;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameException;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;


@Entity
@Getter
@Setter
@Table(name = "userCrypto")
public class UserCrypto implements Serializable {

        private Validator validator = new Validator();

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
        private float reputation;

        @Transient
        private Bank bank;

       @Transient
       private LinkedList<CryptoCurrency> cryptoCurrencies;


        public UserCrypto() {
        }


        public UserCrypto (
                Long id,
                String name,
                String surname,
                String address,
                String password,
                String email,
                String cvu,
                String cryptoAddress) throws Exception 
        {
        setName(name);
        setSurame(surname);
        setAddres(address);
        setEmail(email);
        setPassword(password);
        setCvu(cvu);
        setCryptoAddress(cryptoAddress);
        this.id= id;

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

    public void setSurame(String surname) throws UserNameException
    {
        if(!validator.validateLastNameLenght(surname))
            throw new UserNameException(MessageFormat.format("Not valid name length. Must be between {0} and {1}", validator.minLastNameLength(), validator.maxLastNameLength()));
        surname = surname;
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
    //endregion

        public int getNumberOfOperation()
        {
                return numberOfOperation;
        }

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

        public float reputation() throws InvalidReputationException {
            if (numberOfOperation <= 0) {
                throw new InvalidReputationException("error: division by zero");
            }
            setReputation( scores / numberOfOperation);
            return  reputation;
        }

        public  void substractReputation(int takenscores) {
           reputation -= takenscores;
           if (reputation < 0) {
               reputation = 0;
           }
       }



        public void moneyTransfer (String cvu, Bank bank){
           bank.getMoneyTransfers().add(cvu);
        }


        public Boolean checkTransfer (){
            return  getBank().getMoneyTransfers().contains(getCvu());
        }

     public void sendCryptoCurrency(CryptoCurrency cryptoCurrency, UserCrypto user){
            user.getCryptoCurrencies().add(cryptoCurrency);
     }


    }
