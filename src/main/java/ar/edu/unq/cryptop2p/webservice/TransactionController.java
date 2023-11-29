package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.dto.*;
import ar.edu.unq.cryptop2p.model.exceptions.*;
import ar.edu.unq.cryptop2p.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;


@RestController
@Transactional
@RequestMapping("/api/transaction")
@EnableAutoConfiguration
public class TransactionController {


        @Autowired
        private TransactionService transactionService;

        @Operation(summary = "Process transaction")
        @SecurityRequirement(name = "Bearer Authentication")
        @PostMapping("/process")
        public ResponseEntity<TransactionViewDto> process(@RequestHeader(value = "Authorization") String  token,@RequestBody TransactionProcessDto transactionData) throws ConfirmReceptionException, MakeTransferException, BadRequestException, NotFoundException, CancelException {
            TransactionViewDto entity = TransactionViewDto.fromModel(transactionService.process(transactionData));
            ResponseEntity.status(201);
            return  ResponseEntity.ok().body(entity);

        }

    @Operation(summary = "Create transaction")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/create")
    public ResponseEntity<TransactionViewDto> create(@RequestHeader(value = "Authorization") String  token,@RequestBody TransactionSelectionDto transactionData) throws NotFoundException {
            TransactionViewDto entity = TransactionViewDto.fromModel(transactionService.create(transactionData.getIdOption(), transactionData.getIdUserSession()));
            ResponseEntity.status(201);
            return ResponseEntity.ok().body(entity);
      }


    /**get transaction by id**/
    @Operation(summary = "Get a  transaction by Id")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    public ResponseEntity<TransactionViewDto> findById(@RequestHeader(value = "Authorization") String  token,@PathVariable("id") int id) throws NotFoundException {
            TransactionViewDto entity = TransactionViewDto.fromModel(transactionService.findByID(id));
            ResponseEntity.status(200);
            return  ResponseEntity.ok().body(entity);
       }



    @Operation(summary = "Get all transactions")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/transactions")
    public ResponseEntity <List<TransactionViewDto>>getAll(@RequestHeader(value = "Authorization") String  token){
        List<TransactionViewDto> transactions = transactionService.findAll().stream().map( transaction -> TransactionViewDto.fromModel( transaction) ).toList();
        return ResponseEntity.ok().body(transactions);
    }

    /**Acept a user**/
    @Operation(summary = "Acept option for a user")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/acept")
    public ResponseEntity<Transaction> acept(@RequestHeader(value = "Authorization") String  token,@RequestBody TransactionAceptDto transactiondata) throws NotFoundException, BadRequestException {
           Transaction entity = transactionService.acept(transactiondata);
            ResponseEntity.status(200);
            return  ResponseEntity.ok().body(entity);
       }

    @Operation(summary = "traded volume of cryptocurrencies between two dates")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/tradedvolume")
    public ResponseEntity< TradeVolumeViewDto> tradedVolume(@RequestHeader(value = "Authorization") String  token,@RequestBody TradedVoluolumeDto volumeData) throws ParseException, NotFoundException {
            TradeVolumeViewDto transactions = transactionService.tradeVolume(volumeData.convertStringToDate());
            ResponseEntity.status(201);
             return  ResponseEntity.ok().body(transactions);

    }

}
