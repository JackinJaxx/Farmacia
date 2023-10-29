package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Grupo;
import com.klmj.ridi_api.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupo")
public class GrupoController extends PersistenceController<Grupo, Enum>{
    @Autowired
    public GrupoController(GrupoService service){super(service);}
}
