package com.vf.dev.msuniversidadaulas.core.materia;

import com.vf.dev.msuniversidadaulas.core.generic.GenericEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MATERIAS")
public class MateriaEntity extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MATERIA", nullable = false)
    private Integer idMateria;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @JoinColumn(name = "ID_CARRERA")
    private Integer idCarrera;

}