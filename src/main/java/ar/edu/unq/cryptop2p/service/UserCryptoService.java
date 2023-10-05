package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import ar.edu.unq.cryptop2p.persistence.UserCryptoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static  ar.edu.unq.cryptop2p.model.validators.Validator.*;

import java.text.MessageFormat;
import java.util.List;


@Service
public class UserCryptoService {

    @Autowired
    private UserCryptoRepository userRepository;

    @Transactional
    public UserCrypto register(@NotNull UserCrypto user) throws  PreconditionFailedException {
        user.validate();
        if (existByEmail(user.getEmail())) {
            String message = "User with email: "+ user.getEmail() +" is used";
            response(message,HttpStatus.PRECONDITION_FAILED);
            throw new PreconditionFailedException(message);
            }
        return userRepository.save(user);
    }

    private @NotNull Boolean existByEmail(String email) {
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
            String message = MessageFormat.format(" User with Id: {0} not found.", id);
            response(message, HttpStatus.NOT_FOUND);
            throw new NotFoundException(message);
        }
        return user.get();

    }

    @Transactional
    public UserCrypto findByEmail( String email) throws NotFoundException{
        var user =userRepository.findByEmail(email);
        if (user.isEmpty()){
            String message = MessageFormat.format(" User with enail: {0} not found.", email);
            response(message,HttpStatus.NOT_FOUND);
            throw new NotFoundException(message);
        }
          return user.get() ;
    }


}
