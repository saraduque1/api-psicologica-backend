package com.apppsicologica.service;

import com.apppsicologica.domain.model.Pregunta;
import com.apppsicologica.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaService {

    private final PreguntaRepository preguntaRepository;

    @Autowired
    public PreguntaService(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    public List<Pregunta> obtenerPreguntas() {
        return preguntaRepository.findAll();
    }

    public Pregunta obtenerPreguntaPorId(Long id) {
        return preguntaRepository.findById(id).orElse(null);
    }

    public Pregunta guardarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public Pregunta actualizarPregunta(Long id, Pregunta pregunta) {
        Pregunta existingPregunta = preguntaRepository.findById(id).orElse(null);
        if (existingPregunta != null) {
            existingPregunta.setPregunta(pregunta.getPregunta());
            return preguntaRepository.save(existingPregunta);
        } else {
            return null;
        }
    }

    public void eliminarPregunta(Long id) {
        preguntaRepository.deleteById(id);
    }
}

