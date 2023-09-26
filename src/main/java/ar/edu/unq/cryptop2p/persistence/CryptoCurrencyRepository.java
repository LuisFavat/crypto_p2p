package ar.edu.unq.cryptop2p.persistence;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Configuration
@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency,Long> {
    Optional<CryptoCurrency> findByName(String name);
}