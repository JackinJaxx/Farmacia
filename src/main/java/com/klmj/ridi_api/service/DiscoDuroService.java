package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Componente;
import com.klmj.ridi_api.persistence.entity.DiscoDuro;
import com.klmj.ridi_api.persistence.repository.DiscoDuroRepository;
import org.springframework.stereotype.Service;

@Service
public class DiscoDuroService extends PersistenceService<DiscoDuro, Componente>{
    public DiscoDuroService(DiscoDuroRepository repository){super(repository);}
}
