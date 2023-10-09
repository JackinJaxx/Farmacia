package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Incidencia;
import com.klmj.ridi_api.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/incidencias")
public class IncidenciaController extends PersistenceController<Incidencia, Integer> {
    @Autowired
    public IncidenciaController(IncidenciaService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Incidencia> guardar(Incidencia incidencia){
        var incidenciaGuardada = super.guardar(incidencia);

        if(Objects.isNull(incidenciaGuardada.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try{
            if(incidenciaGuardada.getBody().getId() != null){
                logger.info("Una incidencia ha sido encontrada y guardada".formatted(incidenciaGuardada));
                return new ResponseEntity<>(incidenciaGuardada.getBody(), HttpStatus.ACCEPTED);
            }
            logger.info("Una incidencia fue encontrada pero no guardada".formatted(incidenciaGuardada));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (NullPointerException e){
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
