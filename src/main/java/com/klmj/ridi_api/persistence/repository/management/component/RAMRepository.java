package com.klmj.ridi_api.persistence.repository.management.component;

import com.klmj.ridi_api.persistence.entity.management.component.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAMRepository extends JpaRepository<RAM, Long> {
}
