package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Municipio;
import com.klmj.ridi_api.service.MunicipioService;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/municipios")
public class MunicipioController extends PersistenceController<Municipio, Long> {

    @Autowired
    public MunicipioController(MunicipioService service) {
        super(service);
    }

    @Override
    @PostMapping("")
    public ResponseEntity<Municipio> guardar(@RequestBody Municipio municipio) {
        Municipio municipioGuardado = service.guardar(municipio);

        try {
            if (municipioGuardado.getId() != null) {
                logger.info("municipio: %s guardado correctamente".formatted(municipioGuardado));
                return new ResponseEntity<>(municipioGuardado, HttpStatus.CREATED);
            }
            logger.info("municipio: %s no pudo ser guardado en la base de datos"
                    .formatted(municipioGuardado));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e) {
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
