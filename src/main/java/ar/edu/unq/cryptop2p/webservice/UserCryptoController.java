package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.TransactionSelectionDto;
import ar.edu.unq.cryptop2p.model.dto.UserRegisterDto;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import ar.edu.unq.cryptop2p.service.UserCryptoService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(tags = "User services")
@Tag(name = "User services", description = "Manage users")
@RestController
@Transactional
@RequestMapping("/api/user")
@EnableAutoConfiguration

public class UserCryptoController {

    @Autowired
    private UserCryptoService userService;

    /**register a user*/
    @Operation(summary = "Register a user")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/register")
    public  ResponseEntity<UserCrypto> register(@RequestHeader(value = "Authorization") String  token,@RequestBody UserRegisterDto userdata ) throws PreconditionFailedException {
              UserCrypto entity =  userService.register(userdata.toModel());
              ResponseEntity.status(201);
              return ResponseEntity.ok().body(entity);

    }

    @Operation(summary = "Get all users")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/users")
    public ResponseEntity<List<UserCrypto>> getAllUsers(@RequestHeader(value = "Authorization") String  token) {
        List<UserCrypto> users = userService.findAll();
        return ResponseEntity.ok().body(users);

    }


    /**get user by id**/
    @Operation(summary = "Get a user by Id")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    ResponseEntity<UserCrypto> userById(@RequestHeader(value = "Authorization") String  token,@PathVariable("id") int id) throws NotFoundException {
            UserCrypto entity = userService.findByID(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok().body(entity);
        }


    /*** get user by email **/
    @Operation(summary = "Get a user by email")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/email/{email}")
    ResponseEntity<UserCrypto> userByEmail(@RequestHeader(value = "Authorization") String  token,@PathVariable("email") String email) throws NotFoundException {
        UserCrypto entity = userService.findByEmail(email);
        ResponseEntity.status(200);
        return  ResponseEntity.ok().body(entity);
       }


    /**Select a Option For a user**/
    @Operation(summary = "Select a Option For a user")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/select")
    ResponseEntity<UserCrypto> selectOption(@RequestHeader(value = "Authorization") String  token,@RequestBody TransactionSelectionDto transactiondata) throws NotFoundException, BadRequestException {
            UserCrypto entity = userService.select(transactiondata);
            ResponseEntity.status(200);
            return ResponseEntity.ok().body(entity);

    }
}



