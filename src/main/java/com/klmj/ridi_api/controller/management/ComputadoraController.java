package com.klmj.ridi_api.controller.management;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.management.Computadora;
import com.klmj.ridi_api.service.management.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispositivos/computadoras")
public class ComputadoraController extends
        PersistenceController<Computadora, Long> {
    @Autowired
    public ComputadoraController(ComputadoraService service) {
        super(service);
    }
}
