package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Municipio;
import com.klmj.ridi_api.persistence.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService extends PersistenceService<Municipio, Long> {

    @Autowired
    public MunicipioService(MunicipioRepository repository) {
        super(repository);
    }

    @Override
    public Municipio guardar(Municipio municipio) {
        return repository.save(municipio);
    }

    @Override
    public Optional<Municipio> leerPorID(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public List<Municipio> leer(Municipio municipio) {
        return repository.findAll(Example.of(municipio));
    }

    @Override
    public boolean borrar(Long aLong) {
        repository.deleteById(aLong);
        return repository.findById(aLong).isPresent();
    }
}
