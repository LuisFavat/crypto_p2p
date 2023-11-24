package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.model.*;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.exceptions.*;
import ar.edu.unq.cryptop2p.persistence.OptionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  static ar.edu.unq.cryptop2p.model.validators.Validator.*;

import java.text.MessageFormat;
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

    @Transactional (propagation = Propagation.REQUIRES_NEW)
    public Option  post (@NotNull OptionPostDto optionPostDto) throws NotFoundException, BadRequestException {
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

    @Transactional
    public Option findByID(int id) throws NotFoundException {
        var  option = optionRepository.findById(id);
        if (option.isEmpty()) {
            String message = MessageFormat.format(" Option with Id: {0} not found.", id);
            response(message, HttpStatus.NOT_FOUND);
            throw new NotFoundException(message);
        }
        return option.get();

    }

   }

