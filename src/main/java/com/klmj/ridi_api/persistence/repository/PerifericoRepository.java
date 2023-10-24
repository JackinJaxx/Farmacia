package com.klmj.ridi_api.persistence.repository;

import com.klmj.ridi_api.persistence.entity.Dispositivo;
import com.klmj.ridi_api.persistence.entity.Periferico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerifericoRepository extends JpaRepository<Periferico, Dispositivo> {
}
