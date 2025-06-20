package ar.edu.utn.frc.tup.piii.PracticaParcial.Services.impl;

import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.NuevaRespuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.RespuestaFechaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Respuesta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository.PreguntasRepository;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository.RespuestaRepository;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Services.RespuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RespuestaServiceImpl implements RespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final PreguntasRepository preguntasRepository;

    @Override
    public void nuevaRespuesta(NuevaRespuestaDTO nuevaRespuesta) {
        List<Respuesta> respuestas = nuevaRespuesta.getRespuestas().stream()
                .map(RespuestaDTO -> {
            Pregunta pregunta = preguntasRepository.findById(RespuestaDTO.getPreguntaId())
                    .orElseThrow( () -> new RuntimeException("Pregunta no encontrada"));
            Respuesta respuesta = new Respuesta();
            respuesta.setPregunta(pregunta);
            respuesta.setContenido(RespuestaDTO.getContido());
            respuesta.setFechaRespuesta(LocalDateTime.now());

            return respuesta;
        }).collect(Collectors.toList());

        respuestaRepository.saveAll(respuestas);
    }

    @Override
    public List<RespuestaFechaDTO> getRespuestasDeHoy() {
        return respuestaRepository.findRespuestasDeHoy().stream()
                .map(this::converToRespuestaConFechaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RespuestaFechaDTO> getRespuestasPorFecha(LocalDate desde, LocalDate hasta) {
        LocalDateTime fechaDesde = desde.atStartOfDay();
        LocalDateTime fechaHasta = hasta.atTime(23, 59, 59);

        return respuestaRepository.findByFechaRespuestaBetween(fechaDesde, fechaHasta).stream()
                .map(this::converToRespuestaConFechaDTO).collect(Collectors.toList());
    }

    private RespuestaFechaDTO converToRespuestaConFechaDTO(Respuesta respuesta) {
        return new RespuestaFechaDTO(
                respuesta.getId(),
                respuesta.getContenido(),
                respuesta.getFechaRespuesta(),
                respuesta.getPregunta().getContenido(),
                respuesta.getPregunta().getEncuesta().getTitulo()
        );
    }
}
