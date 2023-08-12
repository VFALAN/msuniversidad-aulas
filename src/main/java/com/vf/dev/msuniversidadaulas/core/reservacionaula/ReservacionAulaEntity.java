package com.vf.dev.msuniversidadaulas.core.reservacionaula;

import com.vf.dev.msuniversidadaulas.core.aula.AulaEntity;
import com.vf.dev.msuniversidadaulas.core.generic.GenericEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "RESERVACIONES_AULAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservacionAulaEntity extends GenericEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESERVACION_AULA")
    private Integer idReservacionAula;
    @Column(name = "HORA_INICIO")
    private LocalTime horaInicio;
    @Column(name = "HORA_FIN")
    private LocalTime horaFin;

    @JoinColumn(name = "ID_AULA")
    @ManyToOne
    private AulaEntity idAula;
}
