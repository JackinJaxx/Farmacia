package com.klmj.ridi_api.persistence.repository;

import com.klmj.ridi_api.persistence.entity.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.embedd.HistorialComputadoraPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialComputadoraRepository extends JpaRepository<HistorialComputadora, HistorialComputadoraPrimaryKey> {
}
