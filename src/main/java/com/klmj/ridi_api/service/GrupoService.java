package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Grupo;
import com.klmj.ridi_api.persistence.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService extends PersistenceService<Grupo, Enum>{
    @Autowired
    public GrupoService(GrupoRepository repository){super(repository);}
}
