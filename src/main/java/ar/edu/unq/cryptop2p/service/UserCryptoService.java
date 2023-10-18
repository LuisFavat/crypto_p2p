package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.OptionSelectDto;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import ar.edu.unq.cryptop2p.persistence.OptionRepository;
import ar.edu.unq.cryptop2p.persistence.UserCryptoRepository;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static  ar.edu.unq.cryptop2p.model.validators.Validator.*;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;


@Service
public class UserCryptoService {

    @Autowired
    private UserCryptoRepository userRepository;

    @Autowired
    private OptionService optionService;

    @Transactional
    public UserCrypto register( UserCrypto user) throws  PreconditionFailedException {
        user.validate();
        if (existByEmail(user.getEmail())) {
            String message = "User with email: "+ user.getEmail() +" is used";
            response(message,HttpStatus.PRECONDITION_FAILED);
            throw new PreconditionFailedException(message);
            }
        return userRepository.save(user);
    }

    private  Boolean existByEmail(String email) {
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

    @Transactional
    public UserCrypto select(OptionSelectDto optiondata) throws NotFoundException {
        var counterPartyUser = findByID(optiondata.getIdCounterParty());
        var option =    optionService.findByID(optiondata.getIdOption());
         counterPartyUser.getOptioms().add(option);
        return userRepository.save(counterPartyUser);
    }

}
