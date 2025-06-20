package ar.edu.utn.frc.tup.piii.PracticaParcial.DTO;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RespuestaIndividualDTO {
    @Id
    private Long preguntaId;

    private String contenido;
}