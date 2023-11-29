package ar.edu.unq.cryptop2p.webservice.auth;

import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.TokenDto;
import ar.edu.unq.cryptop2p.model.dto.UserLoginDto;
import ar.edu.unq.cryptop2p.model.dto.UserRegisterDto;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import ar.edu.unq.cryptop2p.service.CustomUserDetailsService;
import ar.edu.unq.cryptop2p.service.UserCryptoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import static ar.edu.unq.cryptop2p.model.validators.Validator.getResponse;


@RestController
@Transactional
@RequestMapping( "/auth")
@EnableAutoConfiguration
public class AuthController {

    @Autowired
    private UserCryptoService userService;

   @Autowired
   private CustomUserDetailsService customerUserDetailsService;

    /**login a user*/
    @Operation(summary = "Login a user")
    @PostMapping("/login")
    public  ResponseEntity<TokenDto> login(@RequestBody UserLoginDto userdata ) {
        ResponseEntity response;
        try {
            TokenDto entity =  customerUserDetailsService.login(userdata);
            ResponseEntity.status(201);
            response = ResponseEntity.ok().body(entity);
        } catch (Exception e) {

            HashMap result = getResponse();
            response = ResponseEntity.status(400).body(result);
        }
        return response ;

    }




    /**register a user*/
    @Operation(summary = "Register a user")
    @PostMapping("/register")
    public  ResponseEntity<UserCrypto> register(@RequestBody UserRegisterDto userdata ) {
        ResponseEntity response;
        try {
            UserCrypto entity =  userService.register(userdata.toModel());
            ResponseEntity.status(201);
            response = ResponseEntity.ok().body(entity);
        } catch (Exception e) {

            HashMap result = getResponse();
            response = ResponseEntity.status(400).body(result);
        }
        return response ;

    }


}