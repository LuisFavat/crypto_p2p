package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.exceptions.ItemNotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PriceNotInAValidRangeException;
import ar.edu.unq.cryptop2p.persistence.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public Option post(Option option) throws ItemNotFoundException, PriceNotInAValidRangeException {
        CryptoCurrency cryptocurrency = option.getCryptocurrency();
        UserCrypto user = option.getUser();
        if (option.validateOptionPriceInARangeOfFiveUpAndDown()) {
            throw new PriceNotInAValidRangeException("You cannot post, the option Price" +
                    option.getPrice() + " is outside the reference price" + option.quote());
        }
        return optionRepository.save(option);

    }
   }

