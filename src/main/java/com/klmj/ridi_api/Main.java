package com.klmj.ridi_api;

import com.klmj.ridi_api.persistence.entity.Estado;

public class Main {
    public static void main(String[] args) {
        Estado estado = new Estado(0L, "CHIAPAS");
        System.out.println(estado);
    }
}
