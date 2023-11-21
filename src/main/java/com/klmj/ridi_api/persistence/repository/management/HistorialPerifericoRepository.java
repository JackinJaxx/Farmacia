package com.klmj.ridi_api.persistence.repository.management;

import com.klmj.ridi_api.persistence.entity.management.HistorialPeriferico;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialPerifericoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialPerifericoRepository
        extends JpaRepository<HistorialPeriferico, HistorialPerifericoId> {

    List<HistorialPeriferico> findByPeriferico_Serial(long serialPeriferico);

    Integer countByPeriferico_Serial(long serialPeriferico);
}
