package com.klmj.ridi_api.persistence.repository;

import com.klmj.ridi_api.persistence.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
