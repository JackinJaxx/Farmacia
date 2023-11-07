package com.klmj.ridi_api.persistence.entity.abstracts;

public interface History <U extends Historiable<?>> {
    void setUpper(U u);
}
