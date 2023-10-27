package com.klmj.ridi_api.controller.location;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.location.Locacion;
import com.klmj.ridi_api.service.location.LocacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/locacion")
public class LocacionController extends PersistenceController<Locacion, Long> {
    @Autowired
    public LocacionController(LocacionService service){super(service);}
}