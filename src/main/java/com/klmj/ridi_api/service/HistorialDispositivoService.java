package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.HistorialDispositivo;
import com.klmj.ridi_api.persistence.entity.embedd.HistorialDispositivoPrimaryKey;
import com.klmj.ridi_api.persistence.repository.HistorialDispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialDispositivoService extends PersistenceService<HistorialDispositivo, HistorialDispositivoPrimaryKey> {
    @Autowired
    public HistorialDispositivoService(HistorialDispositivoRepository repository) {
        super(repository);
    }
}
