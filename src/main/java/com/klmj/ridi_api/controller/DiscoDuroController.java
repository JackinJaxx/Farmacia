package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.CPU;
import com.klmj.ridi_api.persistence.entity.Componente;
import com.klmj.ridi_api.persistence.entity.DiscoDuro;
import com.klmj.ridi_api.persistence.entity.RAM;
import com.klmj.ridi_api.service.CPUService;
import com.klmj.ridi_api.service.DiscoDuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/disco_duro")
public class DiscoDuroController extends PersistenceController<DiscoDuro, Componente>{
    @Autowired
    public DiscoDuroController(DiscoDuroService service) {
        super(service);
    }

    @Override
    @PostMapping
    public ResponseEntity<DiscoDuro> guardar(@RequestBody DiscoDuro discoDuro){
        var discoDuroGuardado = super.guardar(discoDuro);

        if (Objects.isNull(discoDuroGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (discoDuroGuardado.getBody().getComponente().getNoSerieComponente() != null) {
                logger.info("periferico: %s guardado correctamente".formatted( discoDuroGuardado));
                return new ResponseEntity<>(discoDuroGuardado.getBody(), HttpStatus.CREATED);
            }
            logger.info("periferico: %s NO pudo ser guardado en la base de datos"
                    .formatted(discoDuroGuardado.getBody()));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e) {
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
