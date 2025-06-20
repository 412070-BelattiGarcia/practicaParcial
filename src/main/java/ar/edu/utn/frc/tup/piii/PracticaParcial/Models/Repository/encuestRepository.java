package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository;

import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface encuestRepository extends JpaRepository<Encuesta, Integer> {

}
