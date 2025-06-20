package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository;

import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {
    @Query("SELECT r FROM Respuesta r WHERE DATE(r.fechaRespuesta) = CURRENT_DATE")
    List<Respuesta> findRespuestasDeHoy();

    @Query("SELECT r FROM Respuesta r WHERE r.fechaRespuesta BETWEEN :desde AND :hasta")
    List<Respuesta> findRespuestasByFechaBetween(
            @Param("desde") LocalDateTime desde,
            @Param("hasta") LocalDateTime hasta
    );

    Long countByPreguntaId(Long preguntaId);
}
