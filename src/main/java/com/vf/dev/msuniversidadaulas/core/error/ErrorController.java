package com.vf.dev.msuniversidadaulas.core.error;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Slf4j
public class ErrorController {
    @ExceptionHandler({Exception.class})
    ResponseEntity<String> generalError(Exception e, HttpServletRequest pHttpServletRequest) {
        log.info("error en la URL: " + pHttpServletRequest.getRequestURI());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({MsUniversidadException.class})
    ResponseEntity<ErrorResponseDTO> msuniversidadErrorHandling(MsUniversidadException e, HttpServletRequest pHttpServletRequest) {
        var response = ErrorResponseDTO.builder()
                .isNotificable(false)
                .isHandelable(e.isHandelable())
                .urlOrigin(pHttpServletRequest.getRequestURI())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(response, e.getStatus());
    }


}
