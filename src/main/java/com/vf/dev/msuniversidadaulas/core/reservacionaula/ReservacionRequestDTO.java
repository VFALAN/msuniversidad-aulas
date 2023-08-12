package com.vf.dev.msuniversidadaulas.core.reservacionaula;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservacionRequestDTO implements Serializable {
    private Integer idREsservacionAula;
    @NotBlank
    private LocalTime horaIncio;
    @NotBlank
    private LocalTime horafin;
    @NotBlank
    private Integer idAula;
}
