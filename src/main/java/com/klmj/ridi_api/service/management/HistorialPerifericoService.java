package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.persistence.entity.management.HistorialPeriferico;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialPerifericoId;
import com.klmj.ridi_api.persistence.repository.management.HistorialPerifericoRepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialPerifericoService extends PersistenceService<HistorialPeriferico, HistorialPerifericoId> {
    @Autowired
    public HistorialPerifericoService(HistorialPerifericoRepository repository){super(repository);}
}
