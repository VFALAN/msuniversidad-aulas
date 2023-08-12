package com.vf.dev.msuniversidadaulas.core.reservacionaula;

import com.vf.dev.msuniversidadaulas.core.aula.AulaService;
import com.vf.dev.msuniversidadaulas.core.error.MsUniversidadException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservacionAulaService {

    @Autowired
    private IReservacionAulaEntityRepository iReservacionAulaEntityRepository;
    @Autowired
    private AulaService aulaService;

    @Autowired
    private ModelMapper modelMapper;


    public ReservacionResponseDTO saveFromDto(ReservacionRequestDTO pRequest) throws MsUniversidadException {
        var entityObject = this.modelMapper.map(pRequest, ReservacionAulaEntity.class);
        var aulaEntity = this.aulaService.findById(pRequest.getIdAula());
        if (validarReservacion(pRequest)) {
            entityObject = this.iReservacionAulaEntityRepository.save(entityObject);
            return this.modelMapper.map(entityObject, ReservacionResponseDTO.class);
        } else {
            throw new MsUniversidadException("No hay espacio para reservar el Aula: " + aulaEntity.getNombre(), "ERRL00001", true, HttpStatus.INTERNAL_SERVER_ERROR, false);
        }
    }

    public ReservacionResponseDTO findById(Integer pIdResservacion) throws MsUniversidadException {
        var entity = this.findEntityById(pIdResservacion);
        return this.modelMapper.map(entity, ReservacionResponseDTO.class);
    }

    public ReservacionAulaEntity findEntityById(Integer pIdreservacion) throws MsUniversidadException {
        Optional<ReservacionAulaEntity> optionalEntity = this.iReservacionAulaEntityRepository.findById(pIdreservacion);
        if (optionalEntity.isEmpty()) {
            throw new MsUniversidadException("No se encontro ninguna reservacion con el ID: " + pIdreservacion, "ERRE00001", false, HttpStatus.NOT_FOUND, false);
        } else {
            return optionalEntity.get();
        }
    }

    public List<ReservacionResponseDTO> findAllreservacionesByAula(Integer idAula) throws MsUniversidadException {
        var aulaEntity = this.aulaService.findById(idAula);
        var entitiesList = this.iReservacionAulaEntityRepository.findAllByAula(aulaEntity);
        var responseList = new ArrayList<ReservacionResponseDTO>();
        entitiesList.forEach(e -> {
            responseList.add(this.modelMapper.map(e, ReservacionResponseDTO.class));
        });
        return responseList;
    }

    private boolean validarReservacion(ReservacionRequestDTO pRequest) {
        var reservaciones = this.iReservacionAulaEntityRepository.findReservacionesByIdAulaAnbHorario(pRequest.getIdAula(), pRequest.getHoraIncio(), pRequest.getHorafin());
        return reservaciones.isEmpty();
    }
}
