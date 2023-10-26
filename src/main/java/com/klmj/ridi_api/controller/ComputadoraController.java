package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.management.Computadora;
import com.klmj.ridi_api.service.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispositivos/computadoras")
public class ComputadoraController extends PersistenceController<Computadora, Long> {
    @Autowired
    public ComputadoraController(ComputadoraService service) {
        super(service);
    }

    /*@Override
    @PostMapping
    public ResponseEntity<Computadora> guardar(@RequestBody Computadora computadora){
        var computadoraGuardado = super.guardar(computadora);
        if(Objects.isNull(computadoraGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {

            if(computadoraGuardado.getBody().getSerial() != null) {
                logger.info("Computadora: %s ha sido guardada correctamente".formatted(computadoraGuardado));
                return new ResponseEntity<>(computadoraGuardado.getBody(), HttpStatus.ACCEPTED);
            } else {
                logger.info("La computadora %s NO ha sido guardada correctamente".formatted(computadoraGuardado.getBody()));
                return new ResponseEntity<>(computadoraGuardado.getBody(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (NullPointerException e) {
            logger.info("ocurrió un error inesperado %s".formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }*/


}
