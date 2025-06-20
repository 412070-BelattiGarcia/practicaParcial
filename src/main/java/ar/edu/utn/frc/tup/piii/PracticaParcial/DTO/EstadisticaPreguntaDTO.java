package ar.edu.utn.frc.tup.piii.PracticaParcial.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstadisticaPreguntaDTO {
    private Long preguntaId;
    private String contenidoPregunta;
    private Long cantidadTotalRespuestas;
}