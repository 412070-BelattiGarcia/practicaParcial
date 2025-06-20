package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Pregunta {

    @Id
    private Long id;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "encuesta_id")
    private Encuesta encuesta;


    @OneToMany
    private List<Pregunta> preguntas;

}
