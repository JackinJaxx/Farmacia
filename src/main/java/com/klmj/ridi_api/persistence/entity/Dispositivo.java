package com.klmj.ridi_api.persistence.entity;

import com.klmj.ridi_api.persistence.entity.enumeration.TipoDispositivos;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Esta clase representa un artefacto que consiste en una combinación de componentes electrónicos
 * organizados en circuitos destinados a controlar y aprovechar las señales eléctricas con el propósito
 * de realizar algún proceso informático.
 *
 * Por ejemplo: una computadora, un teclado, un mouse, un altavoz, etc.
 */

@Entity(name = "dispositivos")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Dispositivo {
    @Id
    @Column(name = "id_dispositivo")
    private String id;
    @Enumerated(EnumType.STRING)
    private TipoDispositivos tipo;
    @Column(name = "nombre_dispositivo", length = 35, nullable = false)
    private String nombreDispositivo;
    @Column(length = 100)
    private String descripcion;
    @Column(length = 35)
    private String fabricante;
    @Column(name = "sistema_operativo", length = 20)
    private String sistemaOperativo;
    @Column(name = "nombre_sistema", length = 20)
    private String nombreSistema;
    @Column(name = "esta_presente", length = 20)
    private boolean estaPresente;
}
