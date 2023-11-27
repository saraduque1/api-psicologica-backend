package com.apppsicologica.service;

import com.apppsicologica.domain.model.Respuesta;
import com.apppsicologica.domain.model.UsuarioRecomendacion;
import com.apppsicologica.domain.model.UsuarioRecomendacionId;
import com.apppsicologica.repository.UsuarioRecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRecomendacionService {

    private final UsuarioRecomendacionRepository usuarioRecomendacionRepository;

    @Autowired
    public UsuarioRecomendacionService(UsuarioRecomendacionRepository usuarioRecomendacionRepository) {
        this.usuarioRecomendacionRepository = usuarioRecomendacionRepository;
    }

    public UsuarioRecomendacion crearRecomendacion(UsuarioRecomendacion usuarioRecomendacion) {
        return usuarioRecomendacionRepository.save(usuarioRecomendacion);
    }

    public List<UsuarioRecomendacion> obtenerRecomendacion(){
        return usuarioRecomendacionRepository.findAll();
    }

    public Optional<UsuarioRecomendacion> obtenerRecomendacionPorId(Long idUsuario, Long idRecomendacion) {
        return usuarioRecomendacionRepository.findById(new UsuarioRecomendacionId(idUsuario, idRecomendacion));
    }

    public UsuarioRecomendacion actualizarRecomendacion(UsuarioRecomendacion usuarioRecomendacion) {
        return usuarioRecomendacionRepository.save(usuarioRecomendacion);
    }


    public void eliminarRecomendacion(Long idUsuario, Long idRecomendacion) {
        usuarioRecomendacionRepository.deleteById(new UsuarioRecomendacionId(idUsuario, idRecomendacion));
    }
}

