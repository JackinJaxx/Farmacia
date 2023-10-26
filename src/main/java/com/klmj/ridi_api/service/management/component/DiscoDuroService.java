package com.klmj.ridi_api.service.management.component;

import com.klmj.ridi_api.persistence.entity.management.component.DiscoDuro;
import com.klmj.ridi_api.persistence.repository.management.component.DiscoDuroRepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscoDuroService extends PersistenceService<DiscoDuro, Long> {
    @Autowired
    public DiscoDuroService(DiscoDuroRepository repository) {
        super(repository);
    }
}
