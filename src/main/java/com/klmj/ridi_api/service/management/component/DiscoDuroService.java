package com.klmj.ridi_api.service.management.component;

import com.klmj.ridi_api.persistence.entity.management.component.DiscoDuro;
import com.klmj.ridi_api.persistence.repository.management.component.DiscoDuroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscoDuroService extends ComponentService<DiscoDuro> {
    @Autowired
    public DiscoDuroService(DiscoDuroRepository repository) {
        super(repository);
    }
}
