package com.klmj.ridi_api.controller.management;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.management.HistorialPeriferico;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialPerifericoId;
import com.klmj.ridi_api.service.management.HistorialPerifericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispositivos/perifericos/historial")
public class HistorialPerifericoController extends PersistenceController<HistorialPeriferico, HistorialPerifericoId> {

    protected HistorialPerifericoService service;

    @Autowired
    public HistorialPerifericoController(HistorialPerifericoService service){
        super(service);
        this.service = service;
    }
}
