package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Componente;
import com.klmj.ridi_api.persistence.repository.ComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponenteService extends PersistenceService<Componente, String> {
    @Autowired
    public ComponenteService(ComponenteRepository repository){super(repository);}
}
