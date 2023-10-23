package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.dto.OptionViewDto;
import ar.edu.unq.cryptop2p.service.OptionService;
import io.swagger.v3.oas.annotations.Operation;
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
    @PostMapping("/post")
    public ResponseEntity<Option> post(@RequestBody OptionPostDto optionPostDto ){
        ResponseEntity response;
        try {
            OptionViewDto entity = OptionViewDto.fromModel( optionService.post(optionPostDto) );
            ResponseEntity.status(201);
            response = ResponseEntity.ok().body(entity);
        } catch (Exception e) {

            HashMap result = getResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response ;
    }


    /**get option by id**/
    @Operation(summary = "Get an option by Id")
    @GetMapping("/{id}")
    ResponseEntity<Option> findById(@PathVariable("id") int id) {
        ResponseEntity response;
        try {
            Option entity = optionService.findByID(id);
            ResponseEntity.status(200);
            response = ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            HashMap result = getResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response;
    }

    @Operation(summary = "Get all options")
    @GetMapping("/options")
    public ResponseEntity <List<Option>>getAll(){
        List<Option> options = optionService.findAll();
       return ResponseEntity.ok().body(options);
    }



}
