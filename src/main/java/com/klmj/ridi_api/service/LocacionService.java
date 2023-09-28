package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Locacion;
import com.klmj.ridi_api.persistence.repository.LocacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacionService extends PersistenceService<Locacion, Long> {
    @Autowired
    public LocacionService(LocacionRepository repository) {
        super(repository);
    }
}
