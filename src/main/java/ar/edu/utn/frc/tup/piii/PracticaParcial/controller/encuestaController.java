package ar.edu.utn.frc.tup.piii.PracticaParcial.controller;

import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.EncuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.EncuestaDetalleDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.EstadisticaEncuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.NuevaEncuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Encuesta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Services.EncuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/encuesta")
public class encuestaController {

    private final EncuestaService encuestaService;

    @GetMapping
    public ResponseEntity<List<EncuestaDTO>> getAllEncuestas() {
        try {
            List<EncuestaDTO> encuestas = encuestaService.getAllEncuestas();
            return ResponseEntity.ok(encuestas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncuestaDetalleDTO> getEncuestaById(@PathVariable Long id) {
        try {
            EncuestaDetalleDTO encuesta = encuestaService.getEncuestaById(id);
            return ResponseEntity.ok(encuesta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<EncuestaDetalleDTO> crearEncuesta(@RequestBody NuevaEncuestaDTO nuevaEncuesta) {
        try {
            EncuestaDetalleDTO encuestaCreada = encuestaService.nuevaEncuesta(nuevaEncuesta);
            return ResponseEntity.status(HttpStatus.CREATED).body(encuestaCreada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/estadisticas")
    public ResponseEntity<EstadisticaEncuestaDTO> getEstadisticasEncuesta(@PathVariable Long id) {
        try {
            EstadisticaEncuestaDTO estadisticas = encuestaService.getEstadisticaEncuestasById(id);
            return ResponseEntity.ok(estadisticas);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
