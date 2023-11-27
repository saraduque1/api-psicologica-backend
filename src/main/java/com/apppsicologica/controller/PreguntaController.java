package com.apppsicologica.controller;

import com.apppsicologica.domain.model.Pregunta;
import com.apppsicologica.repository.PreguntaRepository;
import com.apppsicologica.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @GetMapping("/preguntas")
    public ResponseEntity<List<Pregunta>> obtenerPreguntas() {
        List<Pregunta> preguntas = preguntaService.obtenerPreguntas();
        return ResponseEntity.ok(preguntas);
    }


    @GetMapping("/preguntas/{id}")
    public ResponseEntity<Pregunta> getPreguntaById(@PathVariable Long id) {
        try {
            Pregunta pregunta = preguntaService.obtenerPreguntaPorId(id);
            return ResponseEntity.ok(pregunta);
        }catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/preguntas")
    public Pregunta savePregunta(@RequestBody Pregunta pregunta) {
        return preguntaService.guardarPregunta(pregunta);
    }

    @PutMapping("/preguntas/{id}")
    public ResponseEntity<Pregunta> updatePregunta(@PathVariable Long id, @RequestBody Pregunta preguntaRequest) {
        try {
            Pregunta pregunta = preguntaService.actualizarPregunta(id, preguntaRequest);
            return ResponseEntity.ok(pregunta);
        }catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/preguntas/{id}")
    public ResponseEntity<Void> deletePregunta(@PathVariable Long id) {
        try{
            preguntaService.eliminarPregunta(id);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }
}

