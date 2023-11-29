package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.dto.OptionViewDto;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.service.OptionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@Transactional
@RequestMapping("/api/option")
@EnableAutoConfiguration
public class OptionController {

    @Autowired
    private OptionService optionService;

    @Operation(summary = "Post an Option")
    @PostMapping("/post")
    public ResponseEntity<OptionViewDto> post(@RequestBody OptionPostDto optionPostDto ) throws NotFoundException, BadRequestException {
            OptionViewDto entity = OptionViewDto.fromModel( optionService.post(optionPostDto) );
            ResponseEntity.status(201);
           return  ResponseEntity.ok().body(entity);
        }


    /**get option by id**/
    @Operation(summary = "Get an option by Id")
    @GetMapping("/{id}")
    ResponseEntity<Option> findById(@PathVariable("id") int id) throws NotFoundException {
            Option entity = optionService.findByID(id);
            ResponseEntity.status(200);
          return  ResponseEntity.ok().body(entity);

    }

    @Operation(summary = "Get all options")
    @GetMapping("/options")
    public ResponseEntity <List<Option>>getAll(){
        List<Option> options = optionService.findAll();
       return ResponseEntity.ok().body(options);
    }


}
