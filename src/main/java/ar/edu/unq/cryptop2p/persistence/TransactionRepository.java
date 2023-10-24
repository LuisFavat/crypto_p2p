package ar.edu.unq.cryptop2p.persistence;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.UserCrypto;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;



@Configuration
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    //List<Transaction> findTransactionByUserAndDateTimeBetweenOrderByAmountOfCryptoCurrencyAsc(UserCrypto user, Date dateTime, Date dateTime2);


//    @Override
//    List<Transaction> findAllById(Iterable<Integer> integers);
    //List<Transaction> findBy

//    @Override
//    List<Transaction> findAllByOptional(Iterable<Integer> integers);

//    @Query("SELECT * FROM TRANSACTION t WHERE  t.ID_USER_CRYPTO = 1" )
//     List<Transaction> volume(Long idUser, Date star, Date finish);



}
