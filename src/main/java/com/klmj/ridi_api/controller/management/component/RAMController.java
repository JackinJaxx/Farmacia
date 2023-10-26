package com.klmj.ridi_api.controller.management.component;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.management.component.RAM;
import com.klmj.ridi_api.service.management.component.RAMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispositivos/componentes/ram")
public class RAMController extends PersistenceController<RAM, Long> {
    @Autowired
    public RAMController(RAMService service) {
        super(service);
    }
}
