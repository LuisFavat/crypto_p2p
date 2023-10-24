package ar.edu.unq.cryptop2p.persistence;

import ar.edu.unq.cryptop2p.model.Option;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {


}
