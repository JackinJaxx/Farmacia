package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.management.Computadora;
import com.klmj.ridi_api.persistence.repository.ComputadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputadoraService extends PersistenceService<Computadora, Long> {
    @Autowired
    public ComputadoraService(ComputadoraRepository repository){super(repository);}
}
