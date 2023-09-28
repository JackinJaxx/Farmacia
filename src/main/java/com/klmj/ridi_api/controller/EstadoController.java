package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Estado;
import com.klmj.ridi_api.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/estados")
public class EstadoController extends PersistenceController<Estado, Long> {

    @Autowired
    public EstadoController(EstadoService service) {
        super(service);
    }

    @Override
    @PostMapping()
    public ResponseEntity<Estado> guardar(@RequestBody Estado estado) {
        var estadoGuardado = super.guardar(estado);

        if (Objects.isNull(estadoGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (estadoGuardado.getBody().getId() != null) {
                logger.info("estado: %s guardado correctamente".formatted(estadoGuardado));
                return new ResponseEntity<>(estadoGuardado.getBody(), HttpStatus.CREATED);
            }
            logger.info("estado: %s no pudo ser guardado en la base de datos"
                    .formatted(estadoGuardado.getBody()));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e) {
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
