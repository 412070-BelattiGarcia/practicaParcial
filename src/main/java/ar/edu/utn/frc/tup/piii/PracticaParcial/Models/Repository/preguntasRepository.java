package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository;


import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface preguntasRepository extends JpaRepository<Pregunta, Integer> {
}
