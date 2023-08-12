package com.vf.dev.msuniversidadaulas.core.aula;

import com.vf.dev.msuniversidadaulas.core.error.MsUniversidadException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula")
public class AulaController {
    @Autowired
    private AulaService aulaService;
    @Autowired
    private ModelMapper modelMapper;
// todo create update delete findById findByEdificio

    @GetMapping("/{idAula}")
    public ResponseEntity<AulaResponseDTO> findById(@PathVariable("idAula") Integer pIdAula) throws MsUniversidadException {
        var entity = this.aulaService.findById(pIdAula);
        var response = this.modelMapper.map(entity, AulaResponseDTO.class);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<AulaResponseDTO> save(@RequestBody @Valid AulaRequestDTO pRequestObject) {
        var response = this.aulaService.saveFromDTO(pRequestObject);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByEdificio/{idEdificio}")
    public ResponseEntity<List<AulaResponseDTO>> findByEdificio(@PathVariable("idEdificio") Integer pidEdificio) throws Exception {
        var resonse = this.aulaService.findByEdificio(pidEdificio);
        return ResponseEntity.ok(resonse);
    }
}
