package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Estado;
import com.klmj.ridi_api.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/{id}")
    public ResponseEntity<Estado> obtenerPorId(@PathVariable Long id) {
        Estado estado = super.leerPorID(id).getBody();
        try{
        if (estado != null) {
            logger.info("estado: %s obtenido correctamente".formatted(estado.getId()));
            return new ResponseEntity<>(estado, HttpStatus.FOUND);
        } else {
            logger.info("Estado: %s NO ha sido encontrado en la base de datos"
                    .formatted(estado.getId()));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        } catch (NullPointerException f){
                logger.info("ocurrió un error inesperado %s"
                        .formatted(f.getMessage()));
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

    }


    @GetMapping("/todos")
    public ResponseEntity<List<Estado>> leerTodos() {
        List<Estado> estados = super.leerTodos().getBody();
        try {
        if (!estados.isEmpty()) {
            return new ResponseEntity<>(estados, HttpStatus.OK);
        } else {
            logger.info("No se ha encontrado ningun estado en la base de datos");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        } catch (NullPointerException w){
            logger.info("ocurrió un error inesperado %s"
                    .formatted(w.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrar(@PathVariable Long id) {
        boolean eliminado = super.borrar(id).hasBody();
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }


}
