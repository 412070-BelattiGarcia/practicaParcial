package ar.edu.utn.frc.tup.piii.PracticaParcial.Services;

import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.encuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Encuesta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;

import java.util.List;

public interface encuestaService {


    List<Encuesta> getEncuestas ();

    List<encuestaDTO> getEncuestasById (int id);

    Encuesta postEncuesta (Encuesta encuesta, Pregunta pregunta);

}
