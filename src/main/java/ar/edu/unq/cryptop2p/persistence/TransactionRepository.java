package ar.edu.unq.cryptop2p.persistence;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.dto.TradedCryptoAmountDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Configuration
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {


    //jpa query
    @Query("SELECT SUM(t.cryptoAmount) " +
            "FROM Transaction  t  LEFT JOIN options_call" +
            "WHERE t.id_userCrypto = %?1% AND t.executionDay >= %?2% AND t.excutionDay <= %?3% " +
            "GROUP BY t.cryptocurrency.name")
    public TradedCryptoAmountDTO findAllBetween(int userID, LocalDate startRange, LocalDate endRange);

}
