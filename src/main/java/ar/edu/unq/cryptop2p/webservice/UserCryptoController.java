package ar.edu.unq.cryptop2p.webservice;


import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
import ar.edu.unq.cryptop2p.service.UserCryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/user")
@EnableAutoConfiguration

public class UserCryptoController {

    @Autowired
    private UserCryptoService userService;

    /**register a user*/
    @PostMapping("/register")
    public  ResponseEntity<UserCrypto> register(@RequestBody UserCrypto userdata ) throws UserNameExistsException {
        UserCrypto entity = userService.register(userdata);
        ResponseEntity.status(201);
        return ResponseEntity.ok().body(entity);
    }

    @GetMapping("/users")
    public  ResponseEntity<List<UserCrypto>> getAllUsers(){
        List<UserCrypto> users = userService.findAll();
        return ResponseEntity.ok().body(users);

    }

}
