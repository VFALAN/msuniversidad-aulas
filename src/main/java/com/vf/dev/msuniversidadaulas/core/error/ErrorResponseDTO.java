package com.vf.dev.msuniversidadaulas.core.error;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDTO implements Serializable {

    private String urlOrigin;
    private Boolean isHandelable;
    private Boolean isNotificable;
    private String message;
    private String path;
}
