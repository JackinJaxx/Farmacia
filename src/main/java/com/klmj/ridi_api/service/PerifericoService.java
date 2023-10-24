package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Dispositivo;
import com.klmj.ridi_api.persistence.entity.Periferico;
import com.klmj.ridi_api.persistence.repository.LocacionRepository;
import com.klmj.ridi_api.persistence.repository.PerifericoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerifericoService extends PersistenceService<Periferico, Dispositivo>{
    @Autowired
    public PerifericoService(PerifericoRepository repository) {
        super(repository);
    }
}
