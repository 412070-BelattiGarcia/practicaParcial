package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.model;

import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreguntaModel {
    private Long id;
    private String contenido;

    public PreguntaModel(Pregunta pregunta) {
        this.id = pregunta.getId();
        this.contenido = pregunta.getContenido();
    }
}