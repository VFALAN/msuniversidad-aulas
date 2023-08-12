package com.vf.dev.msuniversidadaulas.core.edificio;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/edificios")
public class EdificioController {
    @Autowired
    private IEdificioService iEdificioService;

    @GetMapping("/{idEdificio}")
    public ResponseEntity<EdificioResponseDTO> findById(@PathVariable("idEdificio") Integer pIdEdificio) throws Exception {
        var response = this.iEdificioService.findById(pIdEdificio);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<EdificioResponseDTO> save(@Valid @RequestBody EdificioRequestDTO edificioDTO) {
        var response = this.iEdificioService.saveFromDTO(edificioDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findByPlantel/{idPlantel}")
    public ResponseEntity<List<EdificioResponseDTO>> findByPlantel(@PathVariable("idPlantel") Integer idPlantel) {
        var result = this.iEdificioService.findAllByPlantel(idPlantel);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<EdificioResponseDTO> update(@Valid @RequestBody EdificioRequestDTO edificiorequest) {
        var response = this.iEdificioService.update(edificiorequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idEdificio}")
    public ResponseEntity<Boolean> delete(@PathVariable("idEdificio") Integer idEdificio) throws Exception {
        this.iEdificioService.delete(idEdificio);
        return ResponseEntity.ok(true);
    }
}
