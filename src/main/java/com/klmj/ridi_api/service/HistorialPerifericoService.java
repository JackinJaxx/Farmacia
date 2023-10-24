package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.HistorialPerifericos;
import com.klmj.ridi_api.persistence.entity.embedd.HistorialPerifericoPrimaryKey;
import com.klmj.ridi_api.persistence.repository.HistorialComputadoraRepository;
import com.klmj.ridi_api.persistence.repository.HistorialPerifericoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialPerifericoService extends PersistenceService<HistorialPerifericos, HistorialPerifericoPrimaryKey> {
    @Autowired
    public HistorialPerifericoService(HistorialPerifericoRepository repository) {
        super(repository);
    }
}
