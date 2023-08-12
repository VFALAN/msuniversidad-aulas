package com.vf.dev.msuniversidadaulas.core.edificio;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EdificioResponseDTO implements Serializable {
    private Integer idEdificio;
    private Date fechaActualizacion;
    private Date fechaBaja;
    private Date fechaAlta;
    private Boolean indActivo;
    private String clave;
    private String descripcion;
    private  String nombre;
    private Integer idPlantel;
}
