package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.persistence.entity.management.Computadora;
import com.klmj.ridi_api.persistence.repository.management.ComputadoraRepository;
import com.klmj.ridi_api.service.management.component.CPUService;
import com.klmj.ridi_api.service.management.component.DiscoDuroService;
import com.klmj.ridi_api.service.management.component.RAMService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ComputadoraService extends DispositivoService<Computadora> {
    public RAMService ramService;
    public CPUService cpuService;
    public DiscoDuroService discoDuroService;
    public HistorialComputadoraService historialComputadoraService;

    @Autowired
    public ComputadoraService(
            @Qualifier("computadoraRep") ComputadoraRepository repository) {
        super(repository);
    }

    @Autowired
    public void setRamService(RAMService ramService) {
        this.ramService = ramService;
    }

    @Autowired
    public void setCpuService(CPUService cpuService) {
        this.cpuService = cpuService;
    }

    @Autowired
    public void setDiscoDuroService(DiscoDuroService discoDuroService) {
        this.discoDuroService = discoDuroService;
    }

    @Autowired
    public void setHistorialComputadoraService(HistorialComputadoraService historialComputadoraService) {
        this.historialComputadoraService = historialComputadoraService;
    }

    /**
     * Guarda una computadora a la base de datos, también Guarda los componentes
     * de la computadora.
     * @param computadora el objeto a guardar.
     * @return la computadora guardada.
     */
    @Override
    public Computadora guardar(@NotNull Computadora computadora) {
        var memoriasRam = computadora.getMemoriasRam();
        var procesadores = computadora.getProcesadores();
        var discos = computadora.getDiscos();

        var computadoraGuardada = super.guardar(computadora);

        memoriasRam.forEach(m -> m.setComputadora(computadoraGuardada));
        var ramGuardadas = ramService.guardar(computadora.getMemoriasRam());
        computadoraGuardada.setMemoriasRam(ramGuardadas);

        procesadores.forEach(p -> p.setComputadora(computadoraGuardada));
        var procesadoresGuardados = cpuService.guardar(computadora.getProcesadores());
        computadoraGuardada.setProcesadores(procesadoresGuardados);

        discos.forEach(d -> d.setComputadora(computadoraGuardada));
        var discosGuardados = discoDuroService.guardar(computadora.getDiscos());
        computadoraGuardada.setDiscos(discosGuardados);

        var historial = computadora.getHistorial();
        historial.forEach(h -> h.setComputadora(computadoraGuardada));
        var historialGuardado = historialComputadoraService.guardar(historial);
        computadoraGuardada.setHistorial(historialGuardado);

        return computadoraGuardada;
    }
}
