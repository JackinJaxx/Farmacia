package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.TipoPerifericos;
import com.klmj.ridi_api.persistence.repository.TipoPerifericoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoPerifericoService extends PersistenceService<TipoPerifericos, Long>{
    public TipoPerifericoService(TipoPerifericoRepository repository){super(repository);}
}
