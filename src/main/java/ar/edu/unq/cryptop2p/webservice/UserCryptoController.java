package ar.edu.unq.cryptop2p.webservice;


import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.OptionSelectDto;
import ar.edu.unq.cryptop2p.model.dto.UserRegisterDto;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.service.UserCryptoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import static  ar.edu.unq.cryptop2p.model.validators.Validator.*;

@RestController
@Transactional
@RequestMapping("/api/user")
@EnableAutoConfiguration

public class UserCryptoController {

    @Autowired
    private UserCryptoService userService;

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
                response = ResponseEntity.ok().body(result);
                }
            return response ;

    }

    @Operation(summary = "Get all users")
    @GetMapping("/users")
    public ResponseEntity<List<UserCrypto>> getAllUsers() {
        List<UserCrypto> users = userService.findAll();
        return ResponseEntity.ok().body(users);

    }


    /**get user by id**/
    @Operation(summary = "Get a user by Id")
    @GetMapping("/{id}")
    ResponseEntity<UserCrypto> userById(@PathVariable("id") int id) throws NotFoundException {
        ResponseEntity response;
        try {
            UserCrypto entity = userService.findByID(id);
            ResponseEntity.status(200);
            response = ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            HashMap result = getResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response;
    }


    /*** get user by email **/
    @Operation(summary = "Get a user by email")
    @GetMapping("/email/{email}")
    ResponseEntity<UserCrypto> userByEmail(@PathVariable("email") String email) throws NotFoundException {
        ResponseEntity response;
        try {
            UserCrypto entity = userService.findByEmail(email);
            ResponseEntity.status(200);
            response = ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            HashMap result = getResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response;
    }

    /**Select a Option For a user**/
    @Operation(summary = "Select a Option For a user")
    @GetMapping("select")
    ResponseEntity<UserCrypto> selectOption(@RequestBody OptionSelectDto optiondata) {
        ResponseEntity response;
        try {
            UserCrypto entity = userService.select(optiondata);
            ResponseEntity.status(200);
            response = ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            HashMap result = getResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response;
    }


}



