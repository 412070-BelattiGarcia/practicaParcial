package ar.edu.utn.frc.tup.piii.PracticaParcial.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NuevaEncuestaDTO {

    private String titulo;

    private List<NuevaPreguntaDTO> preguntas;
}