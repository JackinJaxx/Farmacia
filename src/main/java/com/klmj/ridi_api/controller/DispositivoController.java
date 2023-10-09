package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Dispositivo;
import com.klmj.ridi_api.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController extends PersistenceController<Dispositivo, String> {
    @Autowired
    public DispositivoController(DispositivoService service) {
        super(service);
    }

    @Override
    @PostMapping()
    public ResponseEntity<Dispositivo> guardar(@RequestBody Dispositivo dispositivo){
        var dispositivoGuardado = super.guardar(dispositivo);
        if (Objects.isNull(dispositivoGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try{
            if(dispositivoGuardado.getBody().getId() != null){
                logger.info("Dispositivo: %s ha sido guardado correctamente".formatted(dispositivoGuardado));
                return new ResponseEntity<>(dispositivoGuardado.getBody(), HttpStatus.ACCEPTED);
            }
            logger.info("El dispositivo: %s no pudo ser guardado".formatted(dispositivoGuardado.getBody()));
            return new ResponseEntity<>(dispositivoGuardado.getBody(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e ){
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
