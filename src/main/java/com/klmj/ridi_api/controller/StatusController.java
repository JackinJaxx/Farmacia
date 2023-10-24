package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Status;
import com.klmj.ridi_api.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/status")
public class StatusController extends PersistenceController<Status, Long >{

    @Autowired
    public StatusController(StatusService service){super(service);}

    @Override
    @PostMapping
    public ResponseEntity<Status> guardar(@RequestBody Status status){
        var statusGuardado = super.guardar(status);

        if(Objects.isNull(statusGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            Long id = statusGuardado.getBody().getIdStatus();
            if(id != null){
                logger.info("El status %s ha sido guardado correctamente".formatted(statusGuardado));
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            logger.info("El status NO se ha guardado en la base de datos".formatted(statusGuardado.getBody()));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


        } catch (NullPointerException e){
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
