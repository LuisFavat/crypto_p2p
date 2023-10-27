package ar.edu.unq.cryptop2p.persistence;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Configuration
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

   //Optional<List<Transaction>> findTransactionByUserAndDateTimeBetweenOrderByCryptoCurrency(UserCrypto user, Date dateTime, Date dateTime2);
  Optional<List<Transaction>> findTransactionByDateTimeBetweenAndUser(Date dateTime, Date dateTime2, UserCrypto user);



}
