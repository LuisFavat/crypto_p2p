package ar.edu.unq.cryptop2p.persistence;

import ar.edu.unq.cryptop2p.model.Usuario;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Configuration
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {



}

