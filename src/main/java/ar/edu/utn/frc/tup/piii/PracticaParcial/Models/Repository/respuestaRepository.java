package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository;

import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface respuestaRepository extends JpaRepository<Respuesta, Integer> {
}
