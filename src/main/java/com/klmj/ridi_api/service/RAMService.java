package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Componente;
import com.klmj.ridi_api.persistence.entity.RAM;
import com.klmj.ridi_api.persistence.repository.RAMRepository;
import org.springframework.stereotype.Service;

@Service
public class RAMService extends PersistenceService<RAM, Componente>{
    public RAMService(RAMRepository repository){super(repository);}
}
