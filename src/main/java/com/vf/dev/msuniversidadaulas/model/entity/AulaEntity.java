package com.vf.dev.msuniversidadaulas.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "AULAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AulaEntity extends GenericEntity implements Serializable {
    @Id
    @Column(name = "ID_AULA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAula;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name  = "CAPACIDAD")
    private Integer capacidad;

    @JoinColumn(name = "ID_EDIFICIO")
    @ManyToOne
    private EdfificioEntity
            idEdificio;
}
