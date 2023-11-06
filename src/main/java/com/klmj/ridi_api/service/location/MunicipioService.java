package com.klmj.ridi_api.service.location;

import com.klmj.ridi_api.persistence.entity.location.Municipio;
import com.klmj.ridi_api.persistence.repository.location.MunicipioRepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = "com.klmj.ridi_api.service")
public class MunicipioService extends PersistenceService<Municipio, Long> {
    protected EstadoService estadoService;

    @Autowired
    public MunicipioService(
            MunicipioRepository repository,
            EstadoService estadoService) {
        super(repository);
        this.estadoService = estadoService;
    }

    @Override
    public Municipio guardar(@NotNull Municipio municipio) {
        var estado = municipio.getEstado();

        if (!estadoService.siExiste(estado))
            municipio.setEstado(estadoService.guardar(estado));
        return super.guardar(municipio);
    }
}
