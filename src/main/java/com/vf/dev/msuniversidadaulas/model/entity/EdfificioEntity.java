package com.vf.dev.msuniversidadaulas.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "EDIFIOS")
public class EdfificioEntity extends GenericEntity implements Serializable {
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
    @JoinColumn(name = "ID_PLANTEL")
    private Integer idPlantel;
    @OneToMany(mappedBy = "idEdificio")
    @JsonIgnore
    private List<AulaEntity> aulaEntities;
}