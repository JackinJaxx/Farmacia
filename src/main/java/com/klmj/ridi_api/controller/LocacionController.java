package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Locacion;
import com.klmj.ridi_api.service.LocacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/locaciones")
public class LocacionController extends PersistenceController<Locacion, Long> {
    @Autowired
    public LocacionController(LocacionService service) {
        super(service);
    }

    @Override
    @PostMapping()

    public ResponseEntity<Locacion> guardar(@RequestBody Locacion locacion){
        var locacionGuardado = super.guardar(locacion);
                if (Objects.isNull(locacionGuardado.getBody()))
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

                try {
                    if (locacionGuardado.getBody().getId() != null){
                        logger.info("locacion: %s ha sido guardada correctamente".formatted(locacionGuardado));
                    }
                    logger.info("locacion: %s no pudo ser guardado en la base de datos"
                            .formatted(locacionGuardado.getBody()));
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                } catch (NullPointerException e){
                    logger.info("ocurrió un error inesperado %s"
                            .formatted(e.getMessage()));
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
    }
}
