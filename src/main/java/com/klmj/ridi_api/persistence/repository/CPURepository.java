package com.klmj.ridi_api.persistence.repository;

import com.klmj.ridi_api.persistence.entity.CPU;
import com.klmj.ridi_api.persistence.entity.Componente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CPURepository extends JpaRepository<CPU, Componente> {
}
