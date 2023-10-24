package com.klmj.ridi_api.persistence.repository;

import com.klmj.ridi_api.persistence.entity.Componente;
import com.klmj.ridi_api.persistence.entity.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAMRepository extends JpaRepository<RAM, Componente> {
}
