package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Dispositivo;
import com.klmj.ridi_api.persistence.entity.Periferico;
import com.klmj.ridi_api.service.HistorialPerifericoService;
import com.klmj.ridi_api.service.PerifericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/dispositivo/periferico")
public class PerifericoController extends PersistenceController<Periferico, Dispositivo>{
    @Autowired
    public PerifericoController(PerifericoService service) {
        super(service);
    }

    @Override
    @PostMapping
    public ResponseEntity<Periferico> guardar(@RequestBody Periferico periferico){
        var perifericoGuardado = super.guardar(periferico);

        if (Objects.isNull(perifericoGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (perifericoGuardado.getBody().getDispositivo().getId() != null) {
                logger.info("periferico: %s guardado correctamente".formatted(perifericoGuardado));
                return new ResponseEntity<>(perifericoGuardado.getBody(), HttpStatus.CREATED);
            }
            logger.info("periferico: %s NO pudo ser guardado en la base de datos"
                    .formatted(perifericoGuardado.getBody()));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e) {
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
