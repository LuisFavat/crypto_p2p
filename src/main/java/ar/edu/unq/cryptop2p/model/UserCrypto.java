package ar.edu.unq.cryptop2p.model;


import java.io.Serializable;

import ar.edu.unq.cryptop2p.model.exceptions.InvalidReputationException;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
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
                String email,
                String cvu,
                String cryptoAddress){
        this.id= id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.cvu = cvu;
        this.cryptoAddress  = cryptoAddress;
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

        public int reputation() throws InvalidReputationException {
            if (numberOfOperation <= 0) {
                throw new InvalidReputationException("error: division by zero");
            }
            return scores / numberOfOperation;
        }
    }
