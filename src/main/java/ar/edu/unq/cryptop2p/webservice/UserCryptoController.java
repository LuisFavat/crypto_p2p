package ar.edu.unq.cryptop2p.webservice;


import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.UserRegisterDto;
import ar.edu.unq.cryptop2p.model.exceptions.InvalidUserException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
import ar.edu.unq.cryptop2p.service.UserCryptoService;
import io.swagger.models.Response;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
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
    public  ResponseEntity<UserCrypto> register(@RequestBody UserRegisterDto userdata ) throws UserNameExistsException, InvalidUserException {
         ResponseEntity response;
          try {
                UserCrypto entity =  userService.register(userdata.toModel());
                ResponseEntity.status(201);
                response = ResponseEntity.ok().body(entity);
            } catch (Exception e) {
                HashMap result = getBadRequestResponse();
                response = ResponseEntity.ok().body(result);
                }
            return response ;

    }

    @Operation(summary = "Get all users")
    @GetMapping("/users")
    public  ResponseEntity<List<UserCrypto>> getAllUsers(){
       List<UserCrypto> users = userService.findAll();
       return ResponseEntity.ok().body(users);

    }


    /**get user by id**/
    @GetMapping("/{id}")
    ResponseEntity<UserCrypto>  userById(@PathVariable("id") int id) throws NotFoundException {
            ResponseEntity response;
            try {
                UserCrypto entity = userService.findByID(id);
                ResponseEntity.status(200);
                response = ResponseEntity.ok().body(entity);
            } catch (Exception e) {
                HashMap result = getNotFoundResponse();
                response = ResponseEntity.ok().body(result);
            }
            return response;
        }



    /**get user by email**/
    @GetMapping("/email/{email}")
    ResponseEntity<UserCrypto> userByEmail(@PathVariable("email") String email) throws NotFoundException{
         ResponseEntity response;
            try {
                UserCrypto entity = userService.findByEmail(email);
                ResponseEntity.status(200);
                response = ResponseEntity.ok().body(entity);
            } catch (Exception e) {
                HashMap result = getNotFoundResponse();
                response = ResponseEntity.ok().body(result);
            }
            return response;
        }
    }



