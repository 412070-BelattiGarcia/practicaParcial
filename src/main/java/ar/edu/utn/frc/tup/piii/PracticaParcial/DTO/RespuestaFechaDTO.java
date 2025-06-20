package ar.edu.utn.frc.tup.piii.PracticaParcial.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RespuestaFechaDTO {
    private Long id;
    private String contenido;
    private LocalDateTime fechaRespuesta;
    private String contenidoPregunta;
    private String tituloEncuesta;
}