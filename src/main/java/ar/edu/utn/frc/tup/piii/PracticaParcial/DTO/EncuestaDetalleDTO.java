package ar.edu.utn.frc.tup.piii.PracticaParcial.DTO;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EncuestaDetalleDTO {
    @Id
    private Long id;
    private String titulo;
    private List<PreguntaDTO> preguntas;
}