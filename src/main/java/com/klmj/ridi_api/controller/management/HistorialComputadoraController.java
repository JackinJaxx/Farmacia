package com.klmj.ridi_api.controller.management;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.persistence.entity.management.Computadora;
import com.klmj.ridi_api.persistence.entity.management.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialComputadoraId;
import com.klmj.ridi_api.service.management.HistorialComputadoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivos/computadoras/historial")
public class HistorialComputadoraController
        extends PersistenceController<HistorialComputadora, HistorialComputadoraId> {
    protected HistorialComputadoraService service;

    public HistorialComputadoraController(HistorialComputadoraService service) {
        super(service);
        this.service = service;
    }

    @Override
    @PostMapping("/por-historial")
    public ResponseEntity<HistorialComputadora> guardar(HistorialComputadora historialComputadora) {
        System.out.println("GUARDANDO POR HISTORIAL");
        return super.guardar(historialComputadora);
    }

    @GetMapping("/{serial}")
    public ResponseEntity<List<HistorialComputadora>> leerPorComputadora(@PathVariable("serial") long serialComputadora) {
        return new ResponseEntity<>(service.leerPorComputadora(serialComputadora), HttpStatus.FOUND);
    }
}
