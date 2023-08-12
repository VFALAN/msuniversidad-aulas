package com.vf.dev.msuniversidadaulas.core.reservacionaula;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservacionResponseDTO implements Serializable {
    private Integer idREsservacionAula;
    @NotBlank
    private LocalTime horaIncio;
    @NotBlank
    private LocalTime horafin;
    @NotBlank
    private Integer idAula;
}
