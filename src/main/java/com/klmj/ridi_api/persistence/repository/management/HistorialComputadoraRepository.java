package com.klmj.ridi_api.persistence.repository.management;

import com.klmj.ridi_api.persistence.entity.management.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialComputadoraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialComputadoraRepository extends
        JpaRepository<HistorialComputadora, HistorialComputadoraId> {

    @Query("SELECT hc FROM historial_computadora hc " +
            "WHERE hc.computadora.serial = :serial " +
            "ORDER BY hc.fechaRegistro")
    List<HistorialComputadora> findByComputadora(@Param("serial") long serialComputadora);
}
