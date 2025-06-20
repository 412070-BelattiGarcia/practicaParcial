package ar.edu.utn.frc.tup.piii.PracticaParcial.controller;

import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.NuevaRespuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.RespuestaFechaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Services.RespuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/respuestas")
public class RespuestaController {

    private final RespuestaService respuestaService;

    @PostMapping
    public ResponseEntity<Void> crearRespuesta(@RequestBody NuevaRespuestaDTO nuevaRespuesta) {
        try {
            respuestaService.nuevaRespuesta(nuevaRespuesta);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/hoy")
    public ResponseEntity<List<RespuestaFechaDTO>> getRespuestasDeHoy() {
        try {
            List<RespuestaFechaDTO> respuestas = respuestaService.getRespuestasDeHoy();
            return ResponseEntity.ok(respuestas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<RespuestaFechaDTO>> getRespuestasPorFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        try {
            List<RespuestaFechaDTO> respuestas = respuestaService.getRespuestasPorFecha(desde, hasta);
            return ResponseEntity.ok(respuestas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
