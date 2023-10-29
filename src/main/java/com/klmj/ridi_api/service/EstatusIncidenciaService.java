package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.EstatusIncidencia;
import com.klmj.ridi_api.persistence.repository.EstatusIncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstatusIncidenciaService extends PersistenceService<EstatusIncidencia, Enum>{
    @Autowired
    public EstatusIncidenciaService(EstatusIncidenciaRepository repository){super(repository);}
}
