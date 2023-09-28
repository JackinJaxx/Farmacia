package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Estado;
import com.klmj.ridi_api.persistence.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService extends PersistenceService<Estado, Long> {
    @Autowired
    public EstadoService(EstadoRepository repository) {
        super(repository);
    }


}
