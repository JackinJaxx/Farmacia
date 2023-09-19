package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Municipio;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("municipios")
public class MunicipioController extends PersistenceController<Municipio, Long> {

    @Autowired
    public MunicipioController(PersistenceService<Municipio, Long> service) {
        super(service);
    }

    @Override
    @PostMapping("/guardar")
    public ResponseEntity<Municipio> guardar(@RequestBody Municipio municipio) {
        Municipio municipioGuardado = service.guardar(municipio);

        try {
            if (municipioGuardado.getId() != null) {
                logger.info("municipio: %s guardado correctamente".formatted(municipioGuardado));
                return new ResponseEntity<>(municipioGuardado, HttpStatus.CREATED);
            }
            logger.info("municipio: %s no pudo ser guardado en la base de datos"
                    .formatted(municipioGuardado));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e) {
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @GetMapping("/leer-id{id_municipio}")
    public ResponseEntity<Municipio> leerPorID(@PathVariable Long id_municipio) {
        Optional<Municipio> municipioLeido = service.leerPorID(id_municipio);

        return municipioLeido
                .map(m -> new ResponseEntity<>(m, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PostMapping("/leer")
    public ResponseEntity<List<Municipio>> leer(@RequestBody Municipio municipio) {
        List<Municipio> municipiosCapturados = service.leer(municipio);
        return new ResponseEntity<>(municipiosCapturados, HttpStatus.FOUND);
    }

    @Override
    @GetMapping("/leer-todos")
    public ResponseEntity<List<Municipio>> leerTodos() {
        return new ResponseEntity<>(service.leerTodos(), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/borrar/{id_municipio}")
    public ResponseEntity<HttpStatus> borrar(@PathVariable Long id_municipio) {
        boolean resultado = service.borrar(id_municipio);
        return new ResponseEntity<>(resultado ? HttpStatus.OK : HttpStatus.NOT_MODIFIED);
    }
}
