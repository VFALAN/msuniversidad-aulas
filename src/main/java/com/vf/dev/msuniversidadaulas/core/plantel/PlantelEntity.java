package com.vf.dev.msuniversidadaulas.core.plantel;

import com.vf.dev.msuniversidadaulas.core.generic.GenericEntity;
import com.vf.dev.msuniversidadaulas.core.municipio.MunicipioEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="PLANTELES")
public class PlantelEntity extends GenericEntity {

    @Id
    @Column(name = "ID_PLANTEL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlantel;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "NOMBRE")
    private String nombre;

    @JoinColumn(name = "ID_MUNICIPIO")
    @ManyToOne
    private MunicipioEntity idMunicipio;
}
