package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Estado;
import com.klmj.ridi_api.service.EstadoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("estados")
public class EstadoController extends PersistenceController<Estado, Long> {

    @Autowired
    public EstadoController(EstadoService service) {
        super(service);
    }

    @Override
    @PostMapping("/guardar")
    public ResponseEntity<Estado> guardar(@RequestBody Estado estado) {
        Estado estadoGuardado = service.guardar(estado);

        try {
            if (estadoGuardado.getId() != null) {
                logger.info("estado: %s guardado correctamente".formatted(estadoGuardado));
                return new ResponseEntity<>(estadoGuardado, HttpStatus.CREATED);
            }
            logger.info("estado: %s no pudo ser guardado en la base de datos"
                    .formatted(estadoGuardado));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e) {
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @GetMapping("/leer-id/{id_estado}")
    public ResponseEntity<Estado> leerPorID(@PathVariable Long id_estado) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    @PostMapping("/leer")
    public ResponseEntity<List<Estado>> leer(@RequestBody Estado estado) {
        List<Estado> estadosCapturados = service.leer(estado);

        return new ResponseEntity<>(estadosCapturados, HttpStatus.OK);
    }

    @Override
    @GetMapping("leer-todos")
    public ResponseEntity<List<Estado>> leerTodos() {
        return new ResponseEntity<>(service.leerTodos(), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/borrar/{id_estado}")
    public ResponseEntity<HttpStatus> borrar(@PathVariable Long id_estado) {
        boolean resultado = service.borrar(id_estado);
        return new ResponseEntity<>(resultado ? HttpStatus.OK : HttpStatus.NOT_MODIFIED);
    }
}
