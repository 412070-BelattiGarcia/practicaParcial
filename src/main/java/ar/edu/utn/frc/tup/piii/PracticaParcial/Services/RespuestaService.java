package ar.edu.utn.frc.tup.piii.PracticaParcial.Services;

import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.NuevaRespuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.RespuestaFechaDTO;

import java.time.LocalDate;
import java.util.List;

public interface RespuestaService {
    void nuevaRespuesta (NuevaRespuestaDTO nuevaRespuesta);
    List<RespuestaFechaDTO> getRespuestasDeHoy();
    List<RespuestaFechaDTO> getRespuestasPorFecha (LocalDate desde, LocalDate hasta);
}
