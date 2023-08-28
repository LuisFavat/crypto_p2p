package ar.edu.unq.cryptop2p.webservice;


import ar.edu.unq.cryptop2p.model.Usuario;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
import ar.edu.unq.cryptop2p.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/user")
@EnableAutoConfiguration

public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    /**register a user*/
    @PostMapping("/register")
    public  ResponseEntity<Usuario> register(@RequestBody Usuario userdata ) throws UserNameExistsException {
        Usuario entity = userService.register(userdata);
        ResponseEntity.status(201);
        return ResponseEntity.ok().body(entity);
    }

    @GetMapping("/users")
    public  ResponseEntity<List<Usuario>> getAllUsers(){
        List<Usuario> users = userService.findAll();
        return ResponseEntity.ok().body(users);

    }

}
