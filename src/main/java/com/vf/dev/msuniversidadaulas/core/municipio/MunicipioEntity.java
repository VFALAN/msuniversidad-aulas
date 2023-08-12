package com.vf.dev.msuniversidadaulas.core.municipio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vf.dev.msuniversidadaulas.core.plantel.PlantelEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "MUNICIPIOS")
public class MunicipioEntity {
    @Id
    @Column(name = "ID_MUNICIPIO")
    @JsonProperty
    private Integer idMunicipio;
    @Column(name = "CODIGO")
    @JsonProperty
    private String codigo;
    @Column(name = "NOMBRE")
    @JsonProperty
    private String nombre;
   @Column(name="idEstado")
    private Integer idEstado;


    @OneToMany(mappedBy = "idMunicipio")
    private List<PlantelEntity> planteles;

}
