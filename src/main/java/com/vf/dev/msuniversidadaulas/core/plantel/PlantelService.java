package com.vf.dev.msuniversidadaulas.core.plantel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantelService {

    @Autowired
    private IPlantelRepository iPlantelRepository;
    @Autowired
    private ModelMapper modelMapper;

    List<PlantelResponseDTO> findAllByMunicipio(Integer idMunicipio) {
        List<PlantelResponseDTO> list = new ArrayList<>();
        this.iPlantelRepository.findByMunicipio(idMunicipio).forEach(p -> {
            list.add(this.modelMapper.map(p, PlantelResponseDTO.class));
        });
        return list;
    }

    public List<PlantelResponseDTO> findAllByEstado(Integer idEstado) {
        List<PlantelResponseDTO> list = new ArrayList<>();
        this.iPlantelRepository.findAllByEstado(idEstado).forEach(p -> {
            list.add(this.modelMapper.map(p, PlantelResponseDTO.class));
        });

        return list;
    }

}
