package com.klmj.ridi_api.controller.location;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.location.Locacion;
import com.klmj.ridi_api.service.location.LocacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locaciones")
public class LocacionController extends PersistenceController<Locacion, Long> {

    protected LocacionService locacionService;

    @Autowired
    public LocacionController(LocacionService locacionService) {
        super(locacionService);
        this.locacionService = locacionService;
    }

    @GetMapping("/estado/{estado}")
    public List<Locacion> leerPorEstado(@PathVariable("estado") long idEstado) {
        return locacionService.leerPorEstado(idEstado);
    }

    @GetMapping("/municipio/{municipio}")
    public List<Locacion> leerPorMunicipio(@PathVariable("municipio") long idMunicipio) {
        return locacionService.leerPorMunicipio(idMunicipio);
    }
}
