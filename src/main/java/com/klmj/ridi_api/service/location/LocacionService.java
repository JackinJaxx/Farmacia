package com.klmj.ridi_api.service.location;

import com.klmj.ridi_api.persistence.entity.location.Locacion;
import com.klmj.ridi_api.persistence.repository.location.LocacionRepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacionService extends PersistenceService<Locacion, Long> {
    protected LocacionRepository repository;
    protected MunicipioService municipioService;

    @Autowired
    public LocacionService(
            LocacionRepository repository,
            MunicipioService municipioService) {
        super(repository);
        this.repository = repository;
        this.municipioService = municipioService;
    }

    @Override
    public Locacion guardar(@NotNull Locacion locacion) {
        var municipio = locacion.getMunicipio();

        if (!municipioService.siExiste(municipio))
            locacion.setMunicipio(municipioService.guardar(municipio));

        return super.guardar(locacion);
    }

    public List<Locacion> leerPorEstado(String idEstado) {
        return repository.findByMunicipio_Estado_Clave(idEstado);
    }

    public List<Locacion> leerPorMunicipio(long idMunicipio) {
        return repository.findByMunicipio_Id(idMunicipio);
    }
}
