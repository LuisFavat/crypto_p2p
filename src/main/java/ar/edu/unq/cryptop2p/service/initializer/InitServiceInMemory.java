package ar.edu.unq.cryptop2p.service.initializer;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.dto.UserRegisterDto;
import ar.edu.unq.cryptop2p.service.CryptoCurrencyService;
import ar.edu.unq.cryptop2p.service.OptionService;
import ar.edu.unq.cryptop2p.service.TransactionService;
import ar.edu.unq.cryptop2p.service.UserCryptoService;
import jakarta.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional
public class InitServiceInMemory {

    @Autowired
    private UserCryptoService userService;

    @Autowired
    private CryptoCurrencyService cryptoCurrencyService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private TransactionService transactionService;

    protected final Log logger = LogFactory.getLog(getClass());


    @Value("${spring.datasource.driverClassName:NONE}")
    private String className;


    @PostConstruct
    public void initialize()    {
        if (className.equals("org.h2.Driver")) {
            logger.info("Init Data Using H2 DB");
             fireInitialData() ;

        }
    }


    private void fireInitialData() {
        {
            UserRegisterDto ale = new UserRegisterDto( "Ale", "Fariña", "dir1132123123", "Very_Secret!", "ale@gmail.com", "1234567890123456789012", "12345678");
            UserRegisterDto luis = new UserRegisterDto( "Luis", "Favatier", "dir1132123140", "Extremly_Secret!", "luis@gmail.com", "1234567890123456789015", "12345679");

            CryptoCurrency cryptoBTC = new CryptoCurrency("BTC", 30000);

            OptionPostDto optionPostDTO1 = new OptionPostDto(OptionType.OPTIONCALL, "BTC",30005D, 1f, 1L);
            OptionPostDto optionPostDTO2 = new OptionPostDto(OptionType.OPTIONCALL, "BTC",30005D, 1f, 1L);
            OptionPostDto optionPostDTO3 = new OptionPostDto(OptionType.OPTIONPUT, "BTC",30005D, 1f, 1L);
            OptionPostDto optionPostDTO4 = new OptionPostDto(OptionType.OPTIONCALL, "BTC",30005D, 1f, 2L);


            try {
                userService.register(ale.toModel());
                userService.register(luis.toModel());
                cryptoCurrencyService.create(cryptoBTC);

//                optionService.post(optionPostDTO1);
//                optionService.post(optionPostDTO2);
//                optionService.post(optionPostDTO3);
//                optionService.post(optionPostDTO4);
//
//                transactionService.create(1, 2L);
//                transactionService.create(2, 2L);
//                transactionService.create(3, 2L);



            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
    }
}
