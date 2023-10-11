package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.dto.TransactionCreateDto;
import ar.edu.unq.cryptop2p.model.dto.TransactionProcessDto;
import ar.edu.unq.cryptop2p.model.dto.TransactionViewDto;
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
        public ResponseEntity<TransactionViewDto> process(@RequestBody TransactionProcessDto transactionData){
            ResponseEntity response;
            try {
                TransactionViewDto entity = TransactionViewDto.fromModel(transactionService.process(transactionData));
                ResponseEntity.status(201);
                response = ResponseEntity.ok().body(entity);
            } catch (Exception  e) {

                HashMap result = getResponse();
                response = ResponseEntity.ok().body(result);
            }
            return response ;
        }

    @Operation(summary = "Create transaction")
    @PostMapping("/create")
    public ResponseEntity<TransactionViewDto> create(@RequestBody TransactionCreateDto transactionData){
        ResponseEntity response;
        try {
            TransactionViewDto entity = TransactionViewDto.fromModel(transactionService.create(transactionData.getIdOption(), transactionData.getIdCounterParty()));
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
    ResponseEntity<TransactionViewDto> findById(@PathVariable("id") int id) throws NotFoundException {
        ResponseEntity response;
        try {
            TransactionViewDto entity = TransactionViewDto.fromModel(transactionService.findByID(id));
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
    public ResponseEntity <List<TransactionViewDto>>getAll(){
        List<TransactionViewDto> transactions = transactionService.findAll().stream().map( transaction -> TransactionViewDto.fromModel( transaction) ).toList();
        return ResponseEntity.ok().body(transactions);
    }
 }