package com.apppsicologica.controller;


import com.apppsicologica.domain.model.Recomendacion;
import com.apppsicologica.service.RecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RecomendacionController {

    @Autowired
    private RecomendacionService recomendacionService;

    @GetMapping("/recomendaciones")
    public ResponseEntity<List<Recomendacion>> getAllRecomendaciones() {
        List<Recomendacion> recomendaciones = recomendacionService.obtenerRecomendaciones();
        return ResponseEntity.ok(recomendaciones);
    }


    @GetMapping("/recomendaciones/{id}")
    public ResponseEntity<Recomendacion> getRecomendacionById(@PathVariable Long id) {
        try {
            Recomendacion recomendacion = recomendacionService.obtenerRecomendacionPorId(id);
            return ResponseEntity.ok(recomendacion);
        }catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/recomendaciones")
    public Recomendacion saveRecomendacion(@RequestBody Recomendacion recomendacion) {
        return recomendacionService.guardarRecomendacion(recomendacion);
    }

    @PutMapping("/recomendaciones/{id}")
    public ResponseEntity<Recomendacion> updateRecomendacion(@PathVariable Long id, @RequestBody Recomendacion recomendacionRequest) {
        try {
            Recomendacion recomendacion = recomendacionService.actualizarRecomendacion(id, recomendacionRequest);
            return ResponseEntity.ok(recomendacion);
        }catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/recomendaciones/{id}")
    public ResponseEntity<Void> deleteRecomendacion(@PathVariable Long id) {
        try{
            recomendacionService.eliminarRecomendacion(id);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }
}
