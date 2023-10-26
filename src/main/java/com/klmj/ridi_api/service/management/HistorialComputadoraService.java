package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.persistence.entity.management.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialComputadoraId;
import com.klmj.ridi_api.persistence.repository.management.HistorialComputadoraRepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialComputadoraService extends
        PersistenceService<HistorialComputadora, HistorialComputadoraId> {
    protected HistorialComputadoraRepository repository;

    @Autowired
    public HistorialComputadoraService(HistorialComputadoraRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<HistorialComputadora> leerPorComputadora(long serialComputadora) {
        return repository.findByComputadora(serialComputadora);
    }
}
