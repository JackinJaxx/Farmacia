package com.klmj.ridi_api.controller.management;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.management.HistorialPeriferico;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialPerifericoId;
import com.klmj.ridi_api.service.management.HistorialPerifericoService;

public class HistorialPerifericoController extends PersistenceController<HistorialPeriferico, HistorialPerifericoId> {
    protected HistorialPerifericoService service;
    public HistorialPerifericoController(HistorialPerifericoService service){
        super(service);
        this.service = service;
    }
}
