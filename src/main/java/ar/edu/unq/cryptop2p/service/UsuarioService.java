package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.model.Usuario;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
import ar.edu.unq.cryptop2p.persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Transactional
    public Usuario register(Usuario user)  throws UserNameExistsException {

        if (existByEmail(user.getEmail())) {
            throw new UserNameExistsException("User with email: "+ user.getEmail() +" is used");
                                        }
        return userRepository.save(user);
    }

    private Boolean existByEmail(String email) {
        List<Usuario> users = userRepository.findAll();
        return  users.stream().anyMatch(user -> Objects.equals(user.getEmail(), email));
    }


    @Transactional
    public  List<Usuario> findAll() {
        return userRepository.findAll();
    }


}
