package com.vf.dev.msuniversidadaulas.core.plantel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/plantel")
public class PlantalController {
    @Autowired
    private PlantelService plantelService;

    @GetMapping("/findByMunicipio/{idMunicipio}")
    public ResponseEntity<List<PlantelResponseDTO>> findPLantelesByMunicipio(@PathVariable("idMunicipio") Integer idMunicipio) {
        var response = this.plantelService.findAllByMunicipio(idMunicipio);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByEstado/{idEstado}")
    public ResponseEntity<List<PlantelResponseDTO>> findAllByEstado(@PathVariable("idEstado") Integer idEstado) {
        var response = this.plantelService.findAllByEstado(idEstado);
        return ResponseEntity.ok(response);
    }
}
