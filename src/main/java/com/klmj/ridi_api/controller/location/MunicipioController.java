package com.klmj.ridi_api.controller.location;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.location.Estado;
import com.klmj.ridi_api.persistence.entity.location.Municipio;
import com.klmj.ridi_api.service.location.EstadoService;
import com.klmj.ridi_api.service.location.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/municipios")
public class MunicipioController extends PersistenceController<Municipio, Long> {
    @Autowired
    public MunicipioController(MunicipioService service) {
        super(service);
    }
}
