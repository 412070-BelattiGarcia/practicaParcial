package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository;

import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaRepository extends JpaRepository<Encuesta, Long> {

    @Query("SELECT COUNT(r) FROM Respuesta r JOIN r.pregunta p WHERE p.encuesta.id = :encuestaId")
    Long countRespuestasByEncuestaId(@Param("encuestaId") Long encuestaId);
}
