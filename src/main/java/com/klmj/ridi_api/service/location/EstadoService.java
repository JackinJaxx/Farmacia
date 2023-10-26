package com.klmj.ridi_api.service.location;

import com.klmj.ridi_api.persistence.entity.location.Estado;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadoService extends PersistenceService<Estado, Long> {
    @Autowired
    public EstadoService(JpaRepository<Estado, Long> repository) {
        super(repository);
    }
}
