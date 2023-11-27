package com.apppsicologica.service;

import com.apppsicologica.domain.model.Recomendacion;
import com.apppsicologica.repository.RecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacionService {
    private final RecomendacionRepository recomendacionRepository;

    @Autowired
    public RecomendacionService(RecomendacionRepository recomendacionRepository) {
        this.recomendacionRepository = recomendacionRepository;
    }

    public List<Recomendacion> obtenerRecomendaciones() {
        return recomendacionRepository.findAll();
    }

    public Recomendacion obtenerRecomendacionPorId(Long id) {
        return recomendacionRepository.findById(id).orElse(null);
    }

    public Recomendacion guardarRecomendacion(Recomendacion recomendacion) {
        return recomendacionRepository.save(recomendacion);
    }

    public Recomendacion actualizarRecomendacion(Long id, Recomendacion recomendacion) {
        Recomendacion existingRecomendacion = recomendacionRepository.findById(id).orElse(null);
        if (existingRecomendacion != null) {
            existingRecomendacion.setRecomendacion(recomendacion.getRecomendacion());
            return recomendacionRepository.save(existingRecomendacion);
        } else {
            return null;
        }
    }

    public void eliminarRecomendacion(Long id) {
        recomendacionRepository.deleteById(id);
    }
}
