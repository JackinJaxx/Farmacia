package com.klmj.ridi_api.persistence.repository.management;

import com.klmj.ridi_api.persistence.entity.management.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialComputadoraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialComputadoraRepository
        extends JpaRepository<HistorialComputadora, HistorialComputadoraId> {

    List<HistorialComputadora> findByComputadora_Serial(long serialComputadora);
    Integer countByComputadora_Serial(long serialComputadora);
}
