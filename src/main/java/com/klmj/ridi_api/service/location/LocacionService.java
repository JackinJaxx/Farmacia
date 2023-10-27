package com.klmj.ridi_api.service.location;

import com.klmj.ridi_api.persistence.entity.location.Estado;
import com.klmj.ridi_api.persistence.entity.location.Locacion;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LocacionService extends PersistenceService<Locacion, Long> {
    @Autowired
    public LocacionService(JpaRepository<Locacion, Long> repository) {
        super(repository);
    }
}
