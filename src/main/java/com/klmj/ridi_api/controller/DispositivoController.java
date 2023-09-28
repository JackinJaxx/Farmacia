package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Dispositivo;
import com.klmj.ridi_api.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController extends PersistenceController<Dispositivo, String> {
    @Autowired
    public DispositivoController(DispositivoService service) {
        super(service);
    }
}
