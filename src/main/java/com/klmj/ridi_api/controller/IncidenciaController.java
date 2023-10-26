package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Incidencia;
import com.klmj.ridi_api.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/incidencias")
public class IncidenciaController extends PersistenceController<Incidencia, Long> {
    @Autowired
    public IncidenciaController(IncidenciaService service) {
        super(service);
    }
}
