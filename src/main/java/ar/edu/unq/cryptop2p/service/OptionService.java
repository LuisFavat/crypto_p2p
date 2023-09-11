package ar.edu.unq.cryptop2p.service;


import ar.edu.unq.cryptop2p.helpers.OptionProvider;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDTO;
import ar.edu.unq.cryptop2p.model.exceptions.ItemNotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PriceNotInAValidRangeException;
import ar.edu.unq.cryptop2p.persistence.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public Option post(OptionPostDTO optionPostDTO) throws ItemNotFoundException, PriceNotInAValidRangeException {
        CryptoCurrency cryptocurrency = optionPostDTO.getCryptocurrency();
        UserCrypto user = optionPostDTO.getUser();
        if (cryptocurrency.validateOptionPriceInARangeOfFiveUpAndDown(optionPostDTO.getPrice())) {
            throw new PriceNotInAValidRangeException("You cannot post, the option Price" +
                    optionPostDTO.getPrice() + " is outside the reference price" + cryptocurrency.getPrice());
        }
        Option option = new OptionProvider().provide(optionPostDTO);
        return optionRepository.save(option);

    }
   }

