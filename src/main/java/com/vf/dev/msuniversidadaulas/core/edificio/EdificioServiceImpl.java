package com.vf.dev.msuniversidadaulas.core.edificio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EdificioServiceImpl implements IEdificioService {
    @Autowired
    private EdificioEntityRepository edificioEntityRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EdificioResponseDTO delete(Integer idEdificio) throws Exception {
        var edificionEntity = this.findEntityById(idEdificio);
        edificionEntity.setFechaBaja(new Date());
        edificionEntity.setIndActivo(false);
        var edificioSaved = this.save(edificionEntity);
        return this.modelMapper.map(edificioSaved, EdificioResponseDTO.class);

    }

    @Override
    public EdificioResponseDTO update(EdificioRequestDTO edificioResponseDTO) {
        var edificioToSave = this.modelMapper.map(edificioResponseDTO, EdificioEntity.class);
        edificioToSave.setFechaActualizacion(new Date());
        edificioToSave = this.save(edificioToSave);
        return this.modelMapper.map(edificioToSave, EdificioResponseDTO.class);
    }

    @Override
    public EdificioResponseDTO saveFromDTO(EdificioRequestDTO edificioRequestDTO) {
        EdificioEntity edificioEntity = this.modelMapper.map(edificioRequestDTO, EdificioEntity.class);
        edificioEntity.setIndActivo(true);
        edificioEntity.setFechaAlta(new Date());
        edificioEntity = this.save(edificioEntity);
        return this.modelMapper.map(edificioEntity, EdificioResponseDTO.class);
    }

    @Override
    public EdificioResponseDTO findById(Integer pEdificioId) throws Exception {
        return this.modelMapper.map(this.findEntityById(pEdificioId), EdificioResponseDTO.class);
    }

    @Override
    public List<EdificioResponseDTO> findAllByPlantel(Integer idPlantel) {
        var list = this.findAllEntitiesByPlantel(idPlantel);
        List<EdificioResponseDTO> listDto = new ArrayList<>();
        list.forEach(item -> {
            listDto.add(this.modelMapper.map(item, EdificioResponseDTO.class));
        });
        return listDto;
    }


    private EdificioEntity save(EdificioEntity pEntity) {
        return this.edificioEntityRepository.save(pEntity);
    }

    private List<EdificioEntity> findAllEntitiesByPlantel(Integer pIdPlantel) {
        return this.edificioEntityRepository.findByPlantel(pIdPlantel);
    }

    @Override
    public EdificioEntity findEntityById(Integer idEdificio) throws Exception {
        var optional = this.edificioEntityRepository.findById(idEdificio);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Recurso no encontrado");
        }
    }

}
