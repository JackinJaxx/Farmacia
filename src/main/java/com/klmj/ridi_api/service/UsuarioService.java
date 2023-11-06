package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Usuario;
import com.klmj.ridi_api.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends PersistenceService<Usuario, Long> {
    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }
}
