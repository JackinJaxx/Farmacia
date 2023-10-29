package com.klmj.ridi_api.controller.management;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.management.TipoPeriferico;
import com.klmj.ridi_api.service.management.TipoPerifericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipo_periferico")
public class TipoPerifericoController extends PersistenceController<TipoPeriferico, Long> {
    @Autowired
    public TipoPerifericoController(TipoPerifericoService service){super(service);}
}
