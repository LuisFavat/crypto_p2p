package ar.edu.unq.cryptop2p.webservice;


import ar.edu.unq.cryptop2p.model.Usuario;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
import ar.edu.unq.cryptop2p.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@RequestMapping("/api/user")
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


}
