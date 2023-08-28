package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
import ar.edu.unq.cryptop2p.persistence.UserCryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;



@Service
public class UserCryptoService {

    @Autowired
    private UserCryptoRepository userRepository;

    @Transactional
    public UserCrypto register(UserCrypto user)  throws UserNameExistsException {

        if (existByEmail(user.getEmail())) {
            throw new UserNameExistsException("User with email: "+ user.getEmail() +" is used");
                                        }
        return userRepository.save(user);
    }

    private Boolean existByEmail(String email) {
        List<UserCrypto> users = userRepository.findAll();
        return  users.stream().anyMatch(user -> Objects.equals(user.getEmail(), email));
    }


    @Transactional
    public  List<UserCrypto> findAll() {
        return userRepository.findAll();
    }


}
