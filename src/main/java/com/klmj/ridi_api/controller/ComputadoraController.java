package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Computadora;
import com.klmj.ridi_api.persistence.entity.DiscoDuro;
import com.klmj.ridi_api.persistence.entity.Dispositivo;
import com.klmj.ridi_api.persistence.entity.Estado;
import com.klmj.ridi_api.service.ComputadoraService;
import com.klmj.ridi_api.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/dispositivos/computadoras")
public class ComputadoraController extends PersistenceController<Computadora, Dispositivo> {
    @Autowired
    public ComputadoraController(ComputadoraService service) {
        super(service);
    }

    @Override
    @PostMapping
    public ResponseEntity<Computadora> guardar(@RequestBody Computadora computadora){
        var computadoraGuardado = super.guardar(computadora);
        if(Objects.isNull(computadoraGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {

            if(computadoraGuardado.getBody().getId() != null) {
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

    }

    @GetMapping("/{id}")
    public ResponseEntity<Computadora> leerPorId(@PathVariable Dispositivo id) {
        Computadora computadora = super.leerPorID(id).getBody();
        try{
            if (computadora != null) {
                logger.info("Computadora %s obtenida correctamente".formatted(computadora.getId()));
                return new ResponseEntity<>(computadora, HttpStatus.FOUND);
            } else {
                logger.info("La computadora: %s NO ha sido encontrado en la base de datos"
                        .formatted(computadora.getId()));
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException f){
            logger.info("ocurrió un error inesperado %s"
                    .formatted(f.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
