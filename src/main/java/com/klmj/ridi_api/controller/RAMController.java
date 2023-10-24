package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.CPU;
import com.klmj.ridi_api.persistence.entity.Componente;
import com.klmj.ridi_api.persistence.entity.RAM;
import com.klmj.ridi_api.service.CPUService;
import com.klmj.ridi_api.service.RAMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/RAM")
public class RAMController extends PersistenceController<RAM, Componente>{
    @Autowired
    public RAMController(RAMService service) {
        super(service);
    }

    @Override
    @PostMapping
    public ResponseEntity<RAM> guardar(@RequestBody RAM ram){
        var ramGuardado = super.guardar(ram);

        if (Objects.isNull(ramGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (ramGuardado.getBody().getComponente().getNoSerieComponente() != null) {
                logger.info("periferico: %s guardado correctamente".formatted(ramGuardado));
                return new ResponseEntity<>(ramGuardado.getBody(), HttpStatus.CREATED);
            }
            logger.info("periferico: %s NO pudo ser guardado en la base de datos"
                    .formatted(ramGuardado.getBody()));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e) {
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
