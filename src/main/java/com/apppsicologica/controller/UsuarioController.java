package com.apppsicologica.controller;


import com.apppsicologica.domain.dto.LoginDTO;
import com.apppsicologica.domain.model.Usuario;
import com.apppsicologica.exception.UsuarioNotFoundException;
import com.apppsicologica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        return ResponseEntity.ok(usuarioService.obtenerUsuarios());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDTO loginDTO) {
        try {
            Usuario usuarioLogueado = usuarioService.login(loginDTO.getEmail(), loginDTO.getContrasena());
            return ResponseEntity.ok(usuarioLogueado);
        } catch (UsuarioNotFoundException e) {
            return ResponseEntity.status(401).build();
        }
    }
}
