package com.klmj.ridi_api.service.management.component;

import com.klmj.ridi_api.persistence.entity.management.component.Componente;
import com.klmj.ridi_api.persistence.repository.management.component.ComponenteRepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class ComponentService <C extends Componente> extends PersistenceService<C, Long> {

    protected ComponenteRepository<C> repository;

    @Autowired
    public ComponentService(ComponenteRepository<C> repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public C guardar(@NotNull C c) {
        var cSaved = repository.findByNoSerie(c.getNoSerie());
        return (Objects.isNull(cSaved)) ? super.guardar(c) : cSaved;
    }
}
