package com.vf.dev.msuniversidadaulas.core.reservacionaula;

import com.vf.dev.msuniversidadaulas.core.aula.AulaEntity;
import org.hibernate.validator.constraints.pl.NIP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface IReservacionAulaEntityRepository extends JpaRepository<ReservacionAulaEntity, Integer> {
    @Query("select r from ReservacionAulaEntity r where r.indActivo = true and r.idAula.idAula = :idAula and (r.horaInicio between :horaInicio and :horaFin or r.horaFin  between :horaInicio and :horaFin ) ")
    List<ReservacionAulaEntity> findReservacionesByIdAulaAnbHorario(@Param("idAula") Integer pIdAula,
                                                                    @Param("horaInicio") LocalTime pHoraInicio,
                                                                    @Param("horaFin") LocalTime pHoraFin);


    @Query("select r from ReservacionAulaEntity r where r.indActivo =true and r.idAula = :aula")
    List<ReservacionAulaEntity> findAllByAula(@Param("aula") AulaEntity aulaEntity);
}