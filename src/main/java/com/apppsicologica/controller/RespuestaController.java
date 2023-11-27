package com.apppsicologica.controller;

import com.apppsicologica.domain.model.Respuesta;
import com.apppsicologica.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RespuestaController {
    private final RespuestaService respuestaService;

    @Autowired
    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @GetMapping("/respuestas")
    public ResponseEntity<List<Respuesta>> getAllRespuestas() {
        List<Respuesta> respuestas = respuestaService.getAllRespuestas();
        return new ResponseEntity<>(respuestas, HttpStatus.OK);
    }

    @GetMapping("/respuestas/{id}")
    public ResponseEntity<Respuesta> getRespuestaById(@PathVariable Long id) {
        Optional<Respuesta> respuesta = respuestaService.getRespuestaById(id);
        return respuesta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/respuestas")
    public ResponseEntity<Respuesta> saveRespuesta(@RequestBody Respuesta respuesta) {
        Respuesta savedRespuesta = respuestaService.saveRespuesta(respuesta);
        return new ResponseEntity<>(savedRespuesta, HttpStatus.CREATED);
    }

    @PutMapping("/respuestas/{id}")
    public ResponseEntity<Respuesta> updateRespuesta(@PathVariable Long id, @RequestBody Respuesta nuevaRespuesta) {
        Respuesta updatedRespuesta = respuestaService.updateRespuesta(id, nuevaRespuesta);

        return updatedRespuesta != null ?
                new ResponseEntity<>(updatedRespuesta, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/respuestas/{id}")
    public ResponseEntity<Void> deleteRespuesta(@PathVariable Long id) {
        respuestaService.deleteRespuesta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
