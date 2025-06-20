package ar.edu.utn.frc.tup.piii.PracticaParcial.Services.impl;

import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.*;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Encuesta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;


import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository.EncuestaRepository;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository.PreguntasRepository;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Services.EncuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EncuestaServiceImpl implements EncuestaService {


    private final EncuestaRepository encuestaRepository;
    private final PreguntasRepository preguntasRepository;


    @Override
    public List<EncuestaDTO> getAllEncuestas() {
        return encuestaRepository.findAll().stream()
                .map(this::convertToListDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EncuestaDetalleDTO getEncuestaById(Long id) {
        Encuesta encuesta = encuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Encuesta no encontrada"));
        return convertToDetalleDTO(encuesta);
    }

    @Override
    public EncuestaDetalleDTO nuevaEncuesta(NuevaEncuestaDTO nuevaEncuesta) {
        Encuesta encuesta = new Encuesta();
        encuesta.setTitulo(nuevaEncuesta.getTitulo());

        Encuesta savedEncuesta = encuestaRepository.save(encuesta);
        List<Pregunta> preguntas = nuevaEncuesta.getPreguntas().stream()
                .map(PreguntaDTO -> {
                    Pregunta pregunta = new Pregunta();
                    pregunta.setContenido(PreguntaDTO.getContenido());
                    pregunta.setEncuesta(savedEncuesta);
                    return pregunta;
                })
                .collect(Collectors.toList());
        List<Pregunta> savedPreguntas = preguntasRepository.saveAll(preguntas);
        savedEncuesta.setPreguntas(savedPreguntas);

        return convertToDetalleDTO(savedEncuesta);
    }

    @Override
    public EstadisticaEncuestaDTO getEstadisticaEncuestasById(Long id) {
        Encuesta encuesta = encuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Encuesta no encontrada"));
        List<EstadisticaPreguntaDTO> estadisticas = encuesta.getPreguntas().stream()
                .map(pregunta -> {
                    Long cantidadRespuestas = preguntasRepository.countRespuestasByPreguntaId(pregunta.getId());
                    return new EstadisticaPreguntaDTO(
                            pregunta.getId(),
                            pregunta.getContenido(),
                            cantidadRespuestas
                    );
                })
                .collect(Collectors.toList());

        return new EstadisticaEncuestaDTO(
                encuesta.getId(),
                encuesta.getTitulo(),
                estadisticas
        );
    }



    private EncuestaDTO convertToListDTO(Encuesta encuesta) {
        Long cantidadRespuestas = encuestaRepository.countRespuestasByEncuestaId(encuesta.getId());
        return new EncuestaDTO(
                encuesta.getId(),
                encuesta.getTitulo(),
                encuesta.getPreguntas() != null ? encuesta.getPreguntas().size() : 0,
                cantidadRespuestas.intValue()
        );
    }
    private EncuestaDetalleDTO convertToDetalleDTO(Encuesta encuesta) {
        List<PreguntaDTO> preguntasDTO = encuesta.getPreguntas().stream()
                .map(pregunta -> new PreguntaDTO(pregunta.getId(), pregunta.getContenido()))
                .collect(Collectors.toList());

        return new EncuestaDetalleDTO(
                encuesta.getId(),
                encuesta.getTitulo(),
                preguntasDTO
        );
    }
}
