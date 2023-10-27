package com.klmj.ridi_api.controller.management;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.management.Periferico;
import com.klmj.ridi_api.service.management.PerifericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispositivos/perifericos")
public class PerifericoController extends PersistenceController<Periferico, Long> {
    @Autowired
    public PerifericoController(PerifericoService service){super(service);}
}
