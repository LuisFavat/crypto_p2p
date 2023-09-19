package ar.edu.unq.cryptop2p.service.initializer;

import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
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

    protected final Log logger = LogFactory.getLog(getClass());


    @Value("${spring.datasource.driverClassName:NONE}")
    private String className;


    @PostConstruct
    public void initialize() throws Exception  {
        if (className.equals("org.h2.Driver")) {
            logger.info("Init Data Using H2 DB");
             fireInitialData() ;

        }
    }


    private void fireInitialData() throws Exception  {
    UserCrypto ale = new UserCrypto(0L, "Ale", "Fariña","dir1132123123", "Very_Secret!", "ale@gmail.com", "1234567890123456789012", "12345678" );
    UserCrypto luis = new UserCrypto(0L, "Luis", "Favatier","dir1132123140", "Extremly_Secret!", "luis@gmail.com", "1234567890123456789015", "12345679" );


       //  UserCrypto ale = new UserCrypto(0L, "Ale", "Fariña","dir1", "Very_Secret!", "ale@gmail.com", "cvu123", "dircripto123" );
      //   UserCrypto luis = new UserCrypto(0L, "Luis", "Favatier","dir2", "Very_Secret!", "luis@gmail.com", "cvu456", "dircripto456");
        try {
        userService.register(ale) ;
        userService.register(luis);
        }
        catch (UserNameExistsException e) {
           e.fillInStackTrace();
        }
    }





}
