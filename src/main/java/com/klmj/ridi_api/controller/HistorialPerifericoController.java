package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.HistorialPerifericos;
import com.klmj.ridi_api.persistence.entity.embedd.HistorialPerifericoPrimaryKey;
import com.klmj.ridi_api.service.HistorialComputadoraService;
import com.klmj.ridi_api.service.HistorialPerifericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Service
@RequestMapping("/historial_periferico")
public class HistorialPerifericoController extends PersistenceController<HistorialPerifericos, HistorialPerifericoPrimaryKey>{
    @Autowired
    public HistorialPerifericoController(HistorialPerifericoService service) {
        super(service);
    }

    @Override
    @PostMapping
    public ResponseEntity<HistorialPerifericos> guardar(HistorialPerifericos historialPeriferico){
        var hpGuardado = super.guardar(historialPeriferico);

        if(Objects.isNull(hpGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try{
            if(hpGuardado.getBody().getPerifericoPrimaryKey() != null){
                logger.info("El historial ha sido guardado correctamente".formatted(hpGuardado.getBody()));
                return new ResponseEntity<>(hpGuardado.getBody(), HttpStatus.ACCEPTED);
            }
            logger.info("Error al seguir guardando el historial".formatted(hpGuardado.getBody()));
            return new ResponseEntity<>(hpGuardado.getBody(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e){
            logger.info("Ocurrió un error inesperado %s".formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
