package com.vf.dev.msuniversidadaulas.core.edificio;

import com.vf.dev.msuniversidadaulas.core.edificio.EdificioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioEntityRepository extends JpaRepository<EdificioEntity, Integer> {
    @Query("select e from EdificioEntity  e where e.indActivo = true and e.idPlantel = :idPlantel")
    List<EdificioEntity> findByPlantel(@Param("idPlantel") Integer idPlantel);
}