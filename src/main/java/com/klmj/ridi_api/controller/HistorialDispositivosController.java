package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.HistorialDispositivo;
import com.klmj.ridi_api.persistence.entity.embedd.HistorialDispositivoPrimaryKey;
import com.klmj.ridi_api.service.HistorialDispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historial_dispositivos")
public class HistorialDispositivosController extends PersistenceController<HistorialDispositivo, HistorialDispositivoPrimaryKey> {
    @Autowired
    public HistorialDispositivosController(HistorialDispositivoService service) {
        super(service);
    }
}
