package ar.edu.unq.cryptop2p.persistence;

import ar.edu.unq.cryptop2p.model.UserCrypto;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Configuration
@Repository
public interface UserCryptoRepository extends JpaRepository<UserCrypto, Long> {


    Optional<UserCrypto> findByEmail(String email);
    Optional<UserCrypto> findById(long id);


}

