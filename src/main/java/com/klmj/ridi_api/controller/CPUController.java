package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.CPU;
import com.klmj.ridi_api.persistence.entity.Componente;
import com.klmj.ridi_api.service.CPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/CPU")
public class CPUController extends PersistenceController<CPU, Componente>{
    @Autowired
    public CPUController(CPUService service) {
        super(service);
    }

    @Override
    @PostMapping
    public ResponseEntity<CPU> guardar(@RequestBody CPU cpu){
        var cpuGuardado = super.guardar(cpu);

        if (Objects.isNull(cpuGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (cpuGuardado.getBody().getComponente().getNoSerieComponente() != null) {
                logger.info("periferico: %s guardado correctamente".formatted(cpuGuardado));
                return new ResponseEntity<>(cpuGuardado.getBody(), HttpStatus.CREATED);
            }
            logger.info("periferico: %s NO pudo ser guardado en la base de datos"
                    .formatted(cpuGuardado.getBody()));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e) {
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
