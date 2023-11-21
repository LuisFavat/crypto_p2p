package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.dto.OptionViewDto;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.service.OptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static ar.edu.unq.cryptop2p.model.validators.Validator.*;
//import org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorImpl;
//import  org.springframework.aop.framework.CglibAopProy;

@RestController
@Transactional
@RequestMapping("/api/option")
@EnableAutoConfiguration
public class OptionController {

    @Autowired
    private OptionService optionService;

    @Operation(summary = "Post an Option")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/post")
    public ResponseEntity<Option> post(@RequestHeader(value = "Authorization") String token,@RequestBody OptionPostDto optionPostDto ){
        ResponseEntity response;
        try {
            OptionViewDto entity = OptionViewDto.fromModel( optionService.post(optionPostDto) );
            ResponseEntity.status(201);
            response = ResponseEntity.ok().body(entity);
        } catch (BadRequestException | NotFoundException e) {

            HashMap result = getResponse();
            response = ResponseEntity.status(400).body(e.getMessage());
        }
        return response ;
    }


    /**get option by id**/
    @Operation(summary = "Get an option by Id")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    ResponseEntity<Option> findById(@RequestHeader(value = "Authorization") String token,@PathVariable("id") int id) {
        ResponseEntity response;
        try {
            Option entity = optionService.findByID(id);
            ResponseEntity.status(200);
            response = ResponseEntity.ok().body(entity);
        } catch (NotFoundException e) {

            HashMap result = getResponse();
            response = ResponseEntity.status(404).body(e.getMessage());
        }

        return response;
    }

    @Operation(summary = "Get all options")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/options")
    public ResponseEntity <List<Option>>getAll(@RequestHeader(value = "Authorization") String token){
        List<Option> options = optionService.findAll();
       return ResponseEntity.ok().body(options);
    }



}
