package com.vf.dev.msuniversidadaulas.core.aula;

import com.vf.dev.msuniversidadaulas.core.edificio.IEdificioService;
import com.vf.dev.msuniversidadaulas.core.error.MsUniversidadException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AulaService {
    @Autowired
    private AulaEntityRepository aulaEntityRepository;
    @Autowired
    private IEdificioService iEdificioService;
    @Autowired
    private ModelMapper modelMapper;

    public AulaEntity findById(Integer idAulaEntity) throws MsUniversidadException {
        Optional<AulaEntity> optionalAulaEntity = this.aulaEntityRepository.findById(idAulaEntity);
        if (optionalAulaEntity.isEmpty()) {
            throw new MsUniversidadException("No se encontro ningun Aula con el ID: " + idAulaEntity, "ERE00001", false, HttpStatus.NOT_FOUND, false);
        } else {
            return optionalAulaEntity.get();
        }
    }

    public AulaResponseDTO saveFromDTO(AulaRequestDTO objectRequest) {
        var entity = this.modelMapper.map(objectRequest, AulaEntity.class);
        entity = this.save(entity);
        return this.modelMapper.map(entity, AulaResponseDTO.class);
    }

    public AulaEntity save(AulaEntity pAulaEntity) {
        return this.aulaEntityRepository.save(pAulaEntity);
    }

    public AulaResponseDTO updateFromDTO(AulaRequestDTO objecrRequest) {
        var entity = this.modelMapper.map(objecrRequest, AulaEntity.class);
        entity.setFechaActualizacion(new Date());
        entity = this.save(entity);
        return this.modelMapper.map(entity, AulaResponseDTO.class);
    }

    public boolean delete(Integer idAula) throws MsUniversidadException {
        var entity = this.findById(idAula);
        entity.setIndActivo(false);
        entity.setFechaBaja(new Date());
        this.aulaEntityRepository.save(entity);
        return true;
    }


    public List<AulaResponseDTO> findByEdificio(Integer idEdificio) throws Exception {
        var entity = this.iEdificioService.findEntityById(idEdificio);
        var aulas = this.aulaEntityRepository.findALlByEdificio(entity);
        var listaResponse = new ArrayList<AulaResponseDTO>();
        aulas.forEach(a -> {
            listaResponse.add(this.modelMapper.map(a, AulaResponseDTO.class));
        });
        return listaResponse;
    }
}
