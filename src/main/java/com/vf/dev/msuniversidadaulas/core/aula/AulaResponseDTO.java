package com.vf.dev.msuniversidadaulas.core.aula;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AulaResponseDTO implements Serializable {

    private Integer idAula;
    private String nombre;
    private String clave;
    private Integer capacidad;
    private Integer idEdificio;
}
