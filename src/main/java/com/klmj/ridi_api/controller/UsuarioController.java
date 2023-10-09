package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Usuario;
import com.klmj.ridi_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends PersistenceController<Usuario, String> {
    @Autowired
    public UsuarioController(UsuarioService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Usuario> guardar(Usuario usuario) {
        var usuarioGuardado = super.guardar(usuario);
        if(Objects.isNull(usuarioGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try{
            if(usuarioGuardado.getBody().getNombre() != null){
                logger.info("Usuario: %s ha sido registrado correctamente".formatted(usuarioGuardado));
                return new ResponseEntity<>(usuarioGuardado.getBody(), HttpStatus.ACCEPTED);
            }
            logger.info("El usuario: %s no ha podido ser registrado exitosamente".formatted(usuarioGuardado.getBody()));
            return new ResponseEntity<>(usuarioGuardado.getBody(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e){
            logger.info("Ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
