package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Dispositivo;
import com.klmj.ridi_api.persistence.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService extends PersistenceService<Dispositivo, String>{
    @Autowired
    public DispositivoService(DispositivoRepository repository) {
        super(repository);
    }
}
