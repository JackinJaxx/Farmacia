package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.EstatusIncidencia;
import com.klmj.ridi_api.service.EstatusIncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatus_incidencia")
public class EstatusIncidenciaController extends PersistenceController<EstatusIncidencia, Enum>{
    @Autowired
    public EstatusIncidenciaController(EstatusIncidenciaService service){super(service);}
}
