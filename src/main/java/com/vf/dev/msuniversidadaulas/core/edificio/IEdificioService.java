package com.vf.dev.msuniversidadaulas.core.edificio;

import com.vf.dev.msuniversidadaulas.core.edificio.EdificioRequestDTO;
import com.vf.dev.msuniversidadaulas.core.edificio.EdificioResponseDTO;

import java.util.List;

public interface IEdificioService {

    EdificioResponseDTO delete(Integer idEdificio) throws Exception;

    EdificioResponseDTO update(EdificioRequestDTO edificioResponseDTO);

    EdificioResponseDTO saveFromDTO(EdificioRequestDTO edificioRequestDTO);

    EdificioResponseDTO findById(Integer pEdificioId) throws Exception;
    EdificioEntity findEntityById(Integer pEdificioId) throws Exception;

    List<EdificioResponseDTO> findAllByPlantel(Integer idPlantel);
}
