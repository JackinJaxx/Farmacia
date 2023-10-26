package com.klmj.ridi_api.persistence.entity;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Contiene todos los grupos y posibles permisos para un Usuario.
 */
public enum Grupo {
    /**
     * Puede hacer lo de un ADMIN, realizar cualquier petición a la API, asi como manipular las
     * variables de configuración.
     */
    DEVELOPER,
    /**
     * Puede hacer lo de un BASIC_USAR, realizar incidencias y darlas de alta como concluidas
     * o reprogramarlas.
     */
    ADMIN,
    /**
     * Puede ver los reportes y hacer peticiones GET, POST y UPDATE a la API.
     */
    BASIC_USER
}
