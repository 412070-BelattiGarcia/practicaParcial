package ar.edu.utn.frc.tup.piii.PracticaParcial.Services.impl;

import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.encuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Encuesta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;


import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository.encuestRepository;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Repository.preguntasRepository;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Services.encuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class encuestaServiceImpl implements encuestaService {


    private final encuestRepository encuestaRepository;
    private final preguntasRepository preguntasRepository;


    @Override
    public List<Encuesta> getEncuestas() {
        return encuestaRepository.findAll();
    }

    @Override
    public List<encuestaDTO> getEncuestasById (int id) {
        List<encuestaDTO> encuestasDTO = new ArrayList<>();

        for (Encuesta encuesta : encuestaRepository.findAll()) {
            encuestaDTO dto = new encuestaDTO();

            dto.setId(encuesta.getId());
            dto.setTitulo(encuesta.getTitulo());
            dto.setCantiadpreguntas(encuesta.getPreguntas().size());
//            dto.setCantidadRespuestas(encuesta.setPreguntas().i;);
            encuestasDTO.add(dto);

        }

        return encuestasDTO;
    }

    @Override
    public Encuesta postEncuesta(Encuesta encuesta, Pregunta pregunta) {


        Encuesta encuesta1 = new Encuesta();

        encuesta1.setTitulo(encuesta.getTitulo());
        Pregunta preguntas = new Pregunta();
        preguntas.setId(pregunta.getId());
        preguntas.setContenido(pregunta.getContenido());
        preguntas.setEncuesta(encuesta);
        preguntasRepository.save(preguntas);
        encuesta1.setPreguntas((List<Pregunta>) preguntas);



        return encuestaRepository.save(encuesta1);
    }
}
