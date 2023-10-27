package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.persistence.entity.management.Periferico;
import com.klmj.ridi_api.persistence.repository.management.PerifericoRepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerifericoService extends PersistenceService<Periferico, Long> {
    @Autowired
    public PerifericoService(PerifericoRepository repository){super(repository);}
}
