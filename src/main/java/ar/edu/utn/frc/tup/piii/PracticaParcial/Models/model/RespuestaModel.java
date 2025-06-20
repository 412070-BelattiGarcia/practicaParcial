package ar.edu.utn.frc.tup.piii.PracticaParcial.Models.model;

import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Respuesta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespuestaModel {
    private Long id;
    private String contenido;
    private LocalDateTime fechaRespuesta;

    public RespuestaModel(Respuesta respuesta) {
        this.id = respuesta.getId();
        this.contenido = respuesta.getContenido();
        this.fechaRespuesta = respuesta.getFechaRespuesta();
    }
}