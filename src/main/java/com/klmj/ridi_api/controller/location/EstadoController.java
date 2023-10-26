package com.klmj.ridi_api.controller.location;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.location.Estado;
import com.klmj.ridi_api.service.location.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController extends PersistenceController<Estado, Long> {
    @Autowired
    public EstadoController(EstadoService service) {
        super(service);
    }
}
