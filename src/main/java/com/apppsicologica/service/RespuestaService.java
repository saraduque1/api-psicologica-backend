package com.apppsicologica.service;

import com.apppsicologica.domain.model.Respuesta;
import com.apppsicologica.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {
    private final RespuestaRepository respuestaRepository;


    @Autowired
    public RespuestaService(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    public List<Respuesta> getAllRespuestas() {
        return respuestaRepository.findAll();
    }

    public Optional<Respuesta> getRespuestaById(Long id) {
        return respuestaRepository.findById(id);
    }

    public Respuesta saveRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public Respuesta updateRespuesta(Long id, Respuesta nuevaRespuesta) {
        return respuestaRepository.findById(id).map(respuesta -> {
            respuesta.setUsuario(nuevaRespuesta.getUsuario());
            respuesta.setPregunta(nuevaRespuesta.getPregunta());
            respuesta.setRespuestaEntero(nuevaRespuesta.getRespuestaEntero());
            return respuestaRepository.save(respuesta);
        }).orElse(null);
    }

    public void deleteRespuesta(Long id) {
        respuestaRepository.deleteById(id);
    }
}
