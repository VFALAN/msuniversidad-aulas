package com.vf.dev.msuniversidadaulas.core.aula;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AulaRequestDTO implements Serializable {
    private Integer idAula;
    @NotBlank
    private String nombre;
    @NotBlank
    private String clave;
    @NotBlank
    private Integer capacidad;
    @NotBlank
    private Integer idEdificio;
}
