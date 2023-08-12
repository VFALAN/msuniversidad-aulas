package com.vf.dev.msuniversidadaulas.core.aula;

import com.vf.dev.msuniversidadaulas.core.edificio.EdificioEntity;
import com.vf.dev.msuniversidadaulas.core.generic.GenericEntity;
import com.vf.dev.msuniversidadaulas.core.reservacionaula.ReservacionAulaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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
    @Column(name = "CAPACIDAD")
    private Integer capacidad;
    @JoinColumn(name = "ID_EDIFICIO")
    @ManyToOne
    private EdificioEntity idEdificio;
    @OneToMany(mappedBy = "idAula")
    private List<ReservacionAulaEntity> reservacionesAula;
}
