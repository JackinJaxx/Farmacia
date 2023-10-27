package com.klmj.ridi_api.service.location;

import com.klmj.ridi_api.persistence.entity.location.Municipio;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService extends PersistenceService<Municipio, Long> {
    @Autowired
    public MunicipioService(JpaRepository<Municipio, Long> repository) {
        super(repository);
    }
}
