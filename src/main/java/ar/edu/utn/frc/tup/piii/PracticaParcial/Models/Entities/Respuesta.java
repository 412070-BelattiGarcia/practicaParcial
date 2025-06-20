package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Respuesta {
    @Id
    private Long id;

    @ManyToOne
    private Pregunta pregunta;

    private String contenido;

    @Column(name = "fecha")
    private LocalDateTime fecha;



}
