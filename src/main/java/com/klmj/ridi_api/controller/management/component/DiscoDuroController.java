package com.klmj.ridi_api.controller.management.component;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.management.component.DiscoDuro;
import com.klmj.ridi_api.service.management.component.DiscoDuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispositivos/componentes/disco-duro")
public class DiscoDuroController extends PersistenceController<DiscoDuro, Long> {
    @Autowired
    public DiscoDuroController(DiscoDuroService service) {
        super(service);
    }
}
