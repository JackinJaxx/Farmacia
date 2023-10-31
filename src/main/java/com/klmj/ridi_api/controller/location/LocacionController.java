package com.klmj.ridi_api.controller.location;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.location.Locacion;
import com.klmj.ridi_api.service.location.LocacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locaciones")
public class LocacionController extends PersistenceController<Locacion, Long> {

    protected LocacionService service;

    @Autowired
    public LocacionController(LocacionService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/estado/{estado}")
    public List<Locacion> leerPorEstado(@PathVariable("estado") long idEstado) {
        return service.leerPorEstado(idEstado);
    }

    @GetMapping("/municipio/{municipio}")
    public List<Locacion> leerPorMunicipio(@PathVariable("municipio") long idMunicipio) {
        return service.leerPorMunicipio(idMunicipio);
    }
}
