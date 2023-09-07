package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("controller/persistence/municipio")
public class MunicipioController extends PersistenceController<Municipio, Long> {

    @Autowired
    public MunicipioController(JpaRepository<Municipio, Long> rep) {
        super(rep);
    }

    @Override
    @PostMapping("/guardar")
    public ResponseEntity<Municipio> guardar(@RequestBody Municipio municipio) {
        Municipio municipioGuardado = repository.save(municipio);

        if (municipioGuardado.getId() != null)
            return new ResponseEntity<>(municipioGuardado, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    @GetMapping("/leer")
    public ResponseEntity<Municipio> leerPorID(Long id_municipio) {
        Optional<Municipio> municipioLeido = repository.findById(id_municipio);

        return municipioLeido
                .map(m -> new ResponseEntity<>(m, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
