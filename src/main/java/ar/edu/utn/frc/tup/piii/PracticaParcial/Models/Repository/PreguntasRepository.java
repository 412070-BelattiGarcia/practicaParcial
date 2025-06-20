package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository;


import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PreguntasRepository extends JpaRepository<Pregunta, Integer> {

    List<Pregunta> findByEncuestaId(Long encuestaId);

    @Query("SELECT COUNT(r) FROM Respuesta r WHERE r.pregunta.id = :preguntaId")
    Long countRespuestasByPreguntaId(@Param("preguntaId") Long preguntaId);
}
