package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.helpers.OptionProvider;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.OptionCall;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.exceptions.InvalidResourceException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PriceNotInAValidRangeException;
import ar.edu.unq.cryptop2p.persistence.OptionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  static ar.edu.unq.cryptop2p.model.validators.Validator.*;

import java.util.List;

import static ar.edu.unq.cryptop2p.helpers.OptionProvider.*;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private UserCryptoService userService;


    @Autowired
    private CryptoCurrencyService cryptoService;
/*
  //  @Transactional
    public Option checkOptionPrice(@NotNull Option option) throws  PriceNotInAValidRangeException {

        if ( ! option.validateOptionPriceInARangeOfFiveUpAndDown()) {
            var message = "You cannot post, the option Price" +
            option.getPrice() + " is outside the reference price" + option.quote();
            response(message,HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
            //InvalidRangeRequestResponse(message);
            throw new PriceNotInAValidRangeException(message);
        }
       return optionRepository.save(option);
    }
*/

    @Transactional (propagation = Propagation.REQUIRES_NEW)
    public Option  post (OptionPostDto optionPostDto) throws PriceNotInAValidRangeException, NotFoundException, InvalidResourceException {
        UserCrypto user = userService.findByID(optionPostDto.getUserId());
        CryptoCurrency crypto = cryptoService.findByName(optionPostDto.getCryptoCurrencyName());
        var option = provide(optionPostDto, user,crypto);
        option.checkOptionPrice();
        return optionRepository.save(option);
    }

    @Transactional
    public List<Option> findAll(){
      return   optionRepository.findAll();
    }



   }

