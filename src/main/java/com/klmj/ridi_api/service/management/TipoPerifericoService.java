package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.persistence.entity.management.TipoPeriferico;
import com.klmj.ridi_api.persistence.repository.management.TipoPerifericoRepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPerifericoService extends PersistenceService<TipoPeriferico, Long> {
    @Autowired
    public TipoPerifericoService(TipoPerifericoRepository repository){super(repository);}
}
