package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Municipio;
import com.klmj.ridi_api.persistence.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService extends PersistenceService<Municipio, Long> {
    @Autowired
    public MunicipioService(MunicipioRepository repository) {
        super(repository);
    }
}
