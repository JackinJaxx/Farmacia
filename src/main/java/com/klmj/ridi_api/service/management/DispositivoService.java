package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.persistence.entity.management.Dispositivo;
import com.klmj.ridi_api.persistence.repository.management.DispositivoRepository;
import com.klmj.ridi_api.service.PdfService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.Objects;
/**
 * Esta clase abstracta representa un servicio para administrar entidades `Dispositivo`.
 * Extiende la clase `PdfService`, que proporciona métodos comunes para trabajar con entidades.
 * @param <D> El tipo de entidad `Dispositivo`.
 */
public abstract class DispositivoService <D extends Dispositivo> extends PdfService<D, Long> {

    protected DispositivoRepository<Dispositivo> dispositivoRepository;
    protected DispositivoRepository<D> repository;

    /**
     * Crea una nueva instancia de la clase `DispositivoService`.
     *
     * @param repository La instancia de `DispositivoRepository` a utilizar.
     */
    @Autowired
    public DispositivoService(DispositivoRepository<D> repository) {
        super(repository);
        this.repository = repository;
    }

    @Autowired
    public void setDispositivoRepository(DispositivoRepository<Dispositivo> dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }

    /**
     * Guarda una entidad `Dispositivo`.
     *
     * @param d La entidad `Dispositivo` a guardar.
     * @return La entidad `Dispositivo` guardada.
     */
    @Override
    public D guardar(@NotNull D d) {
        var sD = repository.findByNoSerie(d.getNoSerie());
        if (Objects.isNull(sD)) return super.guardar(d);
        System.out.println(sD.getNoSerie() + "****************************");
        return sD;
    }

    public D leerPorNoSerie(@NotNull String noSerie) {
        return repository.findByNoSerie(noSerie);
    }
}
