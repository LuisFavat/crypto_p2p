package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.exceptions.InvalidUserException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
import ar.edu.unq.cryptop2p.persistence.UserCryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;


@Service
public class UserCryptoService {

    @Autowired
    private UserCryptoRepository userRepository;

    @Transactional
    public UserCrypto register(UserCrypto user)  throws UserNameExistsException, InvalidUserException {
        user.validate();;
        if (existByEmail(user.getEmail())) {
            throw new UserNameExistsException("User with email: "+ user.getEmail() +" is used");
                                        }
        return userRepository.save(user);
    }

    private Boolean existByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


    @Transactional
    public  List<UserCrypto> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public UserCrypto findByID(long id) throws NotFoundException {
        var  user = userRepository.findById(id);
       if (user.isEmpty()) {
            throw new NotFoundException(MessageFormat.format(" User with Id: {0} not found.", id));
        }
        return user.get();

    }

    @Transactional
    public UserCrypto findByEmail( String email) throws NotFoundException{
        var user =userRepository.findByEmail(email);
        if (user.isEmpty()){
            throw new NotFoundException(MessageFormat.format(" User with enail: {0} not found.", email));
        }
          return user.get() ;
    }


}
