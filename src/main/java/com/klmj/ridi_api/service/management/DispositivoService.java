package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.persistence.entity.management.Dispositivo;
import com.klmj.ridi_api.persistence.repository.management.DispositivoRepository;
import com.klmj.ridi_api.service.PdfService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public abstract class DispositivoService <D extends Dispositivo> extends PdfService<D, Long> {

    protected DispositivoRepository<D> repository;

    @Autowired
    public DispositivoService(DispositivoRepository<D> repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public D guardar(@NotNull D d) {
        var sD = repository.findByNoSerie(d.getNoSerie());
        return (Objects.isNull(sD)) ? super.guardar(d) : sD;
    }
}
