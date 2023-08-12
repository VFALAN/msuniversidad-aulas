package com.vf.dev.msuniversidadaulas.core.aula;

import com.vf.dev.msuniversidadaulas.core.aula.AulaEntity;
import com.vf.dev.msuniversidadaulas.core.edificio.EdificioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaEntityRepository extends JpaRepository<AulaEntity, Integer> {
    @Query("SELECT a from AulaEntity a where a.indActivo = true and a.idEdificio = :idEdificio")
    List<AulaEntity> findALlByEdificio(@Param("idEdificio") EdificioEntity pIdEdificio);
}