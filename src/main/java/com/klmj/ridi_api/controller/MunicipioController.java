package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Municipio;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("controller/persistence/municipio")
public class MunicipioController extends PersistenceController<Municipio, Long> {

    @Autowired
    public MunicipioController(PersistenceService<Municipio, Long> service) {
        super(service);
    }

    @Override
    @PostMapping("/guardar")
    public ResponseEntity<Municipio> guardar(@RequestBody Municipio municipio) {
        Municipio municipioGuardado = service.guardar(municipio);

        if (municipioGuardado.getId() != null)
            return new ResponseEntity<>(municipioGuardado, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    @GetMapping("/leer{id_municipio}")
    public ResponseEntity<Municipio> leerPorID(@PathVariable Long id_municipio) {
        Optional<Municipio> municipioLeido = service.leerPorID(id_municipio);

        return municipioLeido
                .map(m -> new ResponseEntity<>(m, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
