package com.klmj.ridi_api.controller.management.component;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.management.component.CPU;
import com.klmj.ridi_api.service.management.component.CPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispositivos/componentes/cpu")
public class CPUController extends PersistenceController<CPU, Long> {
    @Autowired
    public CPUController(CPUService service) {
        super(service);
    }
}
