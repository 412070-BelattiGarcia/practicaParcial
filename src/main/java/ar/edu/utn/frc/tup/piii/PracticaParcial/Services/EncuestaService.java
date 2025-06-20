package ar.edu.utn.frc.tup.piii.PracticaParcial.Services;

import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.EncuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.EncuestaDetalleDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.EstadisticaEncuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.NuevaEncuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Encuesta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;

import java.util.List;

public interface EncuestaService {


    List<EncuestaDTO> getAllEncuestas ();
    EncuestaDetalleDTO getEncuestaById (Long id);
    EncuestaDetalleDTO nuevaEncuesta (NuevaEncuestaDTO nuevaEncuesta);
    EstadisticaEncuestaDTO getEstadisticaEncuestasById (Long id);

}
