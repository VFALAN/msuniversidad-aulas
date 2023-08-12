package com.vf.dev.msuniversidadaulas.core.edificio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vf.dev.msuniversidadaulas.core.aula.AulaEntity;
import com.vf.dev.msuniversidadaulas.core.generic.GenericEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "EDIFICIOS")
public class EdificioEntity extends GenericEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EDIFICIO", nullable = false)
    private Integer idEdificio;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "NUM_PISOS")
    private Integer numPisos;
    @Column(name = "AULAS_PISO")
    private Integer aulasPisos;
    @JoinColumn(name = "ID_PLANTEL")
    private Integer idPlantel;
    @OneToMany(mappedBy = "idEdificio")
    @JsonIgnore
    private List<AulaEntity> aulaEntities;
}