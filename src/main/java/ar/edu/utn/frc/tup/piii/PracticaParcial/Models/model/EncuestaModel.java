package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.model;

import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Encuesta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EncuestaModel {
    private Long id;
    private String titulo;
    private List<PreguntaModel> preguntas;



    public EncuestaModel(Encuesta encuesta) {
        this.id = encuesta.getId();
        this.titulo = encuesta.getTitulo();
        this.preguntas = new ArrayList<>();
        encuesta.getPreguntas().forEach(p -> this.preguntas.add(new PreguntaModel(p)));

    }
}