package com.klmj.ridi_api.service.location;

import com.klmj.ridi_api.persistence.entity.location.Locacion;
import com.klmj.ridi_api.persistence.repository.location.LocacionRepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacionService extends PersistenceService<Locacion, Long> {
    protected LocacionRepository repository;

    @Autowired
    public LocacionService(LocacionRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Locacion> leerPorEstado(long idEstado) {
        return repository.findByEstado(idEstado);
    }

    public List<Locacion> leerPorMunicipio(long idMunicipio) {
        return repository.findByMunicipio(idMunicipio);
    }
}
