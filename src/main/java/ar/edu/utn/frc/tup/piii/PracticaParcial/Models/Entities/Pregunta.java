package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Pregunta {

    @Id
    private Long id;
    private String contenido;

    @ManyToOne
    private Encuesta encuesta;
}
