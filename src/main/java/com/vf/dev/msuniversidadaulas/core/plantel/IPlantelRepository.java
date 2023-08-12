package com.vf.dev.msuniversidadaulas.core.plantel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlantelRepository extends JpaRepository<PlantelEntity, Integer> {

    @Query("select p from PlantelEntity p where p.indActivo = true and p.idMunicipio.idMunicipio = :idMunicipio")
    List<PlantelEntity> findByMunicipio(@Param("idMunicipio") Integer idMunicipio);
    @Query("select p from PlantelEntity p  where p.idMunicipio.idEstado = :idEstado")
    List<PlantelEntity> findAllByEstado(@Param("idEstado")Integer idEstado);
}
