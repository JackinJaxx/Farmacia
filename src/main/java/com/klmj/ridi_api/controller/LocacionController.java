package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Locacion;
import com.klmj.ridi_api.service.LocacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locaciones")
public class LocacionController extends PersistenceController<Locacion, Long> {
    @Autowired
    public LocacionController(LocacionService service) {
        super(service);
    }
}
