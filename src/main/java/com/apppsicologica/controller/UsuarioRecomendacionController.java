package com.apppsicologica.controller;

import com.apppsicologica.domain.model.UsuarioRecomendacion;
import com.apppsicologica.domain.model.UsuarioRecomendacionId;
import com.apppsicologica.service.UsuarioRecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UsuarioRecomendacionController {
    private final UsuarioRecomendacionService usuarioRecomendacionService;

    @Autowired
    public UsuarioRecomendacionController(UsuarioRecomendacionService usuarioRecomendacionService) {
        this.usuarioRecomendacionService = usuarioRecomendacionService;
    }

    @GetMapping("/usuariorecomendaciones")
    public ResponseEntity<List<UsuarioRecomendacion>> getAllUsuarioRecomendaciones() {
        List<UsuarioRecomendacion> usuarioRecomendaciones = usuarioRecomendacionService.obtenerRecomendacion();
        return new ResponseEntity<>(usuarioRecomendaciones, HttpStatus.OK);
    }

    @GetMapping("/usuariorecomendaciones/{idUsuario}/{idRecomendacion}")
    public ResponseEntity<UsuarioRecomendacion> getUsuarioRecomendacionById(
            @PathVariable Long idUsuario,
            @PathVariable Long idRecomendacion) {
        Optional<UsuarioRecomendacion> usuarioRecomendacion = usuarioRecomendacionService.obtenerRecomendacionPorId(idUsuario, idRecomendacion);

        return usuarioRecomendacion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/usuariorecomendaciones")
    public ResponseEntity<UsuarioRecomendacion> saveUsuarioRecomendacion(
            @RequestBody UsuarioRecomendacion usuarioRecomendacion) {
        UsuarioRecomendacion savedUsuarioRecomendacion = usuarioRecomendacionService.crearRecomendacion(usuarioRecomendacion);
        return new ResponseEntity<>(savedUsuarioRecomendacion, HttpStatus.CREATED);
    }

    @PutMapping("/usuariorecomendaciones/{idUsuario}/{idRecomendacion}")
    public ResponseEntity<UsuarioRecomendacion> updateUsuarioRecomendacion(
            @PathVariable Long idUsuario,
            @PathVariable Long idRecomendacion,
            @RequestBody UsuarioRecomendacion newUsuarioRecomendacion) {
        UsuarioRecomendacionId id = new UsuarioRecomendacionId(idUsuario, idRecomendacion);
        UsuarioRecomendacion updatedUsuarioRecomendacion = usuarioRecomendacionService.actualizarRecomendacion(newUsuarioRecomendacion);

        return updatedUsuarioRecomendacion != null ?
                new ResponseEntity<>(updatedUsuarioRecomendacion, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/usuariorecomendaciones/{idUsuario}/{idRecomendacion}")
    public ResponseEntity<Void> deleteUsuarioRecomendacion(
            @PathVariable Long idUsuario,
            @PathVariable Long idRecomendacion) {
        UsuarioRecomendacionId id = new UsuarioRecomendacionId(idUsuario, idRecomendacion);
        usuarioRecomendacionService.eliminarRecomendacion(idUsuario, idRecomendacion);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
