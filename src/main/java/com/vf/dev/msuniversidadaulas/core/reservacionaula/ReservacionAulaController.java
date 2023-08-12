package com.vf.dev.msuniversidadaulas.core.reservacionaula;

import com.vf.dev.msuniversidadaulas.core.error.MsUniversidadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservaciones")
public class ReservacionAulaController {

    @Autowired
    private ReservacionAulaService reservacionAulaService;


    @GetMapping("/{idReservacion}")
    public ResponseEntity<ReservacionResponseDTO> findById(@PathVariable("idresservacion") Integer oIdResservacoin) throws MsUniversidadException {
        var response = this.reservacionAulaService.findById(oIdResservacoin);
        return ResponseEntity.ok(response);
    }
}
