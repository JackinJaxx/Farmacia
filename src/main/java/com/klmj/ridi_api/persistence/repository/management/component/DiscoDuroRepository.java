package com.klmj.ridi_api.persistence.repository.management.component;

import com.klmj.ridi_api.persistence.entity.management.component.DiscoDuro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscoDuroRepository extends JpaRepository<DiscoDuro, Long> {
}
