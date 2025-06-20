package ar.edu.utn.frc.tup.piii.PracticaParcial.controller;

import ar.edu.utn.frc.tup.piii.PracticaParcial.DTO.encuestaDTO;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Encuesta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Models.Entities.Pregunta;
import ar.edu.utn.frc.tup.piii.PracticaParcial.Services.encuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/encuesta")
public class encuestaController {

    private final encuestaService encuestaService;


    @PostMapping
    public ResponseEntity<?> addEncuesta (@RequestBody Encuesta encuesta, Pregunta pregunta) {
        try {
            Encuesta newEncuesta= encuestaService.postEncuesta(encuesta,pregunta);
            if (newEncuesta != null) {
                return ResponseEntity.ok().body(newEncuesta);
            }else {
                return ResponseEntity.badRequest().build();
            }


        } catch (Exception e) {
            System.out.println("Error al crear la encuesta");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping()
    public ResponseEntity<List<Encuesta>> obtenerencuestas() {
        try {
            List<Encuesta> encuestas = encuestaService.getEncuestas();
            if (!encuestas.isEmpty()) {
                return ResponseEntity.ok().body(encuestas);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            System.out.println("Error al obtener encuestas");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<encuestaDTO>> obtenerencuesta(@PathVariable Integer id) {
        try {
            List<encuestaDTO> resEnc = encuestaService.getEncuestasById(id);
            return ResponseEntity.ok().body(resEnc);

        } catch (Exception e) {
            System.out.println("Error al obtener encuestas");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
