package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.HistorialDispositivo;
import com.klmj.ridi_api.persistence.entity.embedd.HistorialDispositivoPrimaryKey;
import com.klmj.ridi_api.service.HistorialDispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/historial_dispositivos")
public class HistorialDispositivosController extends PersistenceController<HistorialDispositivo, HistorialDispositivoPrimaryKey> {
    @Autowired
    public HistorialDispositivosController(HistorialDispositivoService service) {
        super(service);
    }

    @Override
    public ResponseEntity<HistorialDispositivo> guardar(HistorialDispositivo hd){
        var hdGuardado = super.guardar(hd);

        if(Objects.isNull(hdGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try{
            if(hdGuardado.getBody().getPrimaryKey() != null){
                logger.info("El historial ha sido guardado correctamente".formatted(hdGuardado.getBody()));
                return new ResponseEntity<>(hdGuardado.getBody(), HttpStatus.ACCEPTED);
            }
            logger.info("Error al seguir guardando el historial".formatted(hdGuardado.getBody()));
            return new ResponseEntity<>(hdGuardado.getBody(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e){
            logger.info("Ocurrió un error inesperado %s".formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
