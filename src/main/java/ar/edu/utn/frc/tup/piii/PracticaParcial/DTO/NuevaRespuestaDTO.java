package ar.edu.utn.frc.tup.piii.PracticaParcial.DTO;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NuevaRespuestaDTO {
    @Id
    private Long encuestaId;

    private List<RespuestaIndividualDTO> respuestas;
}