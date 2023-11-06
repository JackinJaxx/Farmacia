package com.klmj.ridi_api.persistence.repository.management;

import com.klmj.ridi_api.persistence.entity.management.Computadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputadoraRepository extends JpaRepository<Computadora, Long> {
    @Query("SELECT c.nombreSistema, h.estatus, c.serial FROM computadoras c INNER JOIN c.historial h")
    List<String[]> findNombreSistemaEstatusId();
}
