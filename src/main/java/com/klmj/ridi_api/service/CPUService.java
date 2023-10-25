package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.CPU;
import com.klmj.ridi_api.persistence.entity.Componente;
import com.klmj.ridi_api.persistence.repository.CPURepository;
import org.springframework.stereotype.Service;

@Service
public class CPUService extends PersistenceService<CPU, Componente>{
    public CPUService(CPURepository repository){super(repository);}
}
