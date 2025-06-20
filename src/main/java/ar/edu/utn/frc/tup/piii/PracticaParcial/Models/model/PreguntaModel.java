package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.model;

import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Encuesta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Respuesta;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PreguntaModel {
    private Long id;
    private String contenido;
    private Encuesta encuesta;
    private List<Respuesta> respuestas;
    private int cantidadRespuestas;

    // Constructor desde Entity
    public PreguntaModel(Pregunta pregunta) {
        this.id = pregunta.getId();
        this.contenido = pregunta.getContenido();
        this.encuesta = pregunta.getEncuesta();
        this.cantidadRespuestas = pregunta.get() != null ? pregunta.getRespuestas().size() : 0;
    }
}