package com.klmj.ridi_api.persistence.entity.abstracts;

import java.util.List;

public interface Historiable <H extends History<?>> {
    List<H> getHistorial();
    void setHistorial(List<H> h);
}
