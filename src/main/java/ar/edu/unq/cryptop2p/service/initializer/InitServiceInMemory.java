package ar.edu.unq.cryptop2p.service.initializer;

import ar.edu.unq.cryptop2p.model.Usuario;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
import ar.edu.unq.cryptop2p.service.UsuarioService;
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
    private UsuarioService userService;

    protected final Log logger = LogFactory.getLog(getClass());


    @Value("${spring.datasource.driverClassName:NONE}")
    private String className;


    @PostConstruct
    public void initialize()  {
        if (className.equals("org.h2.Driver")) {
            logger.info("Init Data Using H2 DB");
            fireInitialData() ;

        }
    }

    private void fireInitialData()  {
         Usuario ale = new Usuario(0L, "Ale", "Fariña","dir1", "ale@gmail.com", "cvu123", "dircripto123" );
         Usuario luis = new Usuario(0L, "Luis", "Favatier","dir2", "luis@gmail.com", "cvu456", "dircripto456" );
        try {
        userService.register(ale) ;
        userService.register(luis);
        }
        catch (UserNameExistsException e) {
           e.fillInStackTrace();
        }
    }




}
