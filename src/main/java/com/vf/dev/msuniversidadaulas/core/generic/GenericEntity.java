package com.vf.dev.msuniversidadaulas.core.generic;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class GenericEntity {

    @JsonProperty
    @Column(name="FECHA_ACTUALIZACION")
    private Date fechaActualizacion;
    @JsonProperty
    @Column(name = "FECHA_BAJA")
    private Date fechaBaja;
    @JsonProperty
    @Column(name = "FECHA_ALTA")
    private Date fechaAlta;
    @JsonProperty
    @Column(name = "IND_ACTIVO")
    private Boolean indActivo;


}