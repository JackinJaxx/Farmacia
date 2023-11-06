package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Usuario;
import com.klmj.ridi_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends PersistenceController<Usuario, Long> {
    @Autowired
    public UsuarioController(UsuarioService service) {
        super(service);
    }
}
