package com.klmj.ridi_api.controller.management;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.management.Periferico;
import com.klmj.ridi_api.service.management.PerifericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispositivos/perifericos")
public class PerifericoController extends PersistenceController<Periferico, Long> {
    PerifericoService service;

    @Autowired
    public PerifericoController(PerifericoService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/no-serie/{noSerie}")
    public ResponseEntity<Periferico> leerPorNoSerie(@PathVariable("noSerie") String noSerie) {
        return ResponseEntity.ok(service.leerPorNoSerie(noSerie));
    }
}
