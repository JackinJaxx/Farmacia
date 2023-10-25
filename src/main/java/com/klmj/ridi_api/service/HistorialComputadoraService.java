package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.embedd.HistorialComputadoraPrimaryKey;
import com.klmj.ridi_api.persistence.repository.HistorialComputadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialComputadoraService extends PersistenceService<HistorialComputadora, HistorialComputadoraPrimaryKey> {
    @Autowired
    public HistorialComputadoraService(HistorialComputadoraRepository repository) {
        super(repository);
    }
}
