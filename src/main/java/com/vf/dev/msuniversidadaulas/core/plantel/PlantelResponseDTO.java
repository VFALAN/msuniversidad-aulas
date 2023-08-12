package com.vf.dev.msuniversidadaulas.core.plantel;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlantelResponseDTO implements Serializable {

    private Integer idPlantel;
    private String clave;
    private String nombre;
    private Integer idMunicipio;


}
