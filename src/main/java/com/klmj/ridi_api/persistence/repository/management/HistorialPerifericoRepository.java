package com.klmj.ridi_api.persistence.repository.management;

import com.klmj.ridi_api.persistence.entity.management.HistorialPeriferico;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialPerifericoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialPerifericoRepository
        extends JpaRepository<HistorialPeriferico, HistorialPerifericoId> {

    @Query("SELECT count(hp) FROM historial_periferico hp " +
            "WHERE hp.periferico.serial = :serial")
    Integer countByPeriferico(@Param("serial") long serialPeriferico);
}
