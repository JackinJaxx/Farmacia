package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Incidencia;
import com.klmj.ridi_api.persistence.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidenciaService extends PersistenceService<Incidencia, Long>{
    @Autowired
    public IncidenciaService(IncidenciaRepository repository){super(repository);}
}
