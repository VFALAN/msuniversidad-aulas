package com.vf.dev.msuniversidadaulas.core.edificio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EdificioRequestDTO implements Serializable {

    private Integer idEdificio;
    @NotBlank
    private String clave;
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotNull
    private Integer numPisos;
    @NotNull
    private Integer numAulas;
    @NotNull
    private Integer idPlantel;
}
