package com.vf.dev.msuniversidadaulas.core.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MsUniversidadException extends Exception {
    private String code;
    private boolean isHandelable;
    private HttpStatus status;
    private boolean isNotificable;
    private String path;

    public MsUniversidadException(String message, String strCode, boolean isHandelable, HttpStatus status, boolean isNotificable) {
        super(message);
        setCode(strCode);
        this.isHandelable = isHandelable;
        setStatus(status);
        this.isNotificable = isNotificable;

    }
}
