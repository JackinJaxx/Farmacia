package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.persistence.entity.management.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialComputadoraId;
import com.klmj.ridi_api.persistence.repository.management.HistorialComputadoraRepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class HistorialComputadoraService extends
        PersistenceService<HistorialComputadora, HistorialComputadoraId> {

    protected HistorialComputadoraRepository repository;

    @Autowired
    public HistorialComputadoraService(
            HistorialComputadoraRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /*@Autowired
    public void setComputadoraService(ComputadoraService computadoraService) {
        this.computadoraService = computadoraService;
    }*/

    @Override
    public HistorialComputadora guardar(@NotNull HistorialComputadora historialComputadora) {
        var computadora = historialComputadora.getComputadora();
        if (Objects.isNull(computadora)) return null;

        historialComputadora.setCns(repository.countByComputadora_Serial(computadora.getSerial()) + 1);
        return repository.save(historialComputadora);
    }

    /**
     * Regresa todo el historial de una computadora.
     * @param serialComputadora es la id de computadora.
     * @return una lista con todos los historiales.
     */
    public List<HistorialComputadora> leerPorComputadora(long serialComputadora) {
        return repository.findByComputadora_Serial(serialComputadora);
    }
}
