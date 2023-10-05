package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.dto.TransactionProcessDto;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static ar.edu.unq.cryptop2p.model.validators.Validator.getResponse;

@RestController
@Transactional
@RequestMapping("/api/transaction")
@EnableAutoConfiguration
public class TransactionController {


        @Autowired
        private TransactionService transactionService;

        @Operation(summary = "Process transaction")
        @PostMapping("/process")
        public ResponseEntity<Transaction> process(@RequestBody TransactionProcessDto transactionData){
            ResponseEntity response;
            try {
                Transaction entity = transactionService.process(transactionData);
                ResponseEntity.status(201);
                response = ResponseEntity.ok().body(entity);
            } catch (Exception  e) {

                HashMap result = getResponse();
                response = ResponseEntity.ok().body(result);
            }
            return response ;
        }


    /**get transaction by id**/
    @Operation(summary = "Get a  transaction by Id")
    @GetMapping("/{id}")
    ResponseEntity<Transaction> findById(@PathVariable("id") int id) throws NotFoundException {
        ResponseEntity response;
        try {
            Transaction entity = transactionService.findByID(id);
            ResponseEntity.status(200);
            response = ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            HashMap result = getResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response;
    }


    @Operation(summary = "Get all transactions")
    @GetMapping("/transactions")
    public ResponseEntity <List<Transaction>>getAll(){
        List<Transaction> transactions = transactionService.findAll();
        return ResponseEntity.ok().body(transactions);
    }
 }
