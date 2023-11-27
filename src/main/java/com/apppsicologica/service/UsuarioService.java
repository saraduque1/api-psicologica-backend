package com.apppsicologica.service;

import com.apppsicologica.domain.dto.LoginDTO;
import com.apppsicologica.domain.model.Usuario;
import com.apppsicologica.exception.UsuarioNotFoundException;
import com.apppsicologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario login(String email, String contrasena) {
        return usuarioRepository.findByEmailAndContrasena(email, contrasena)
                .orElseThrow(() -> new UsuarioNotFoundException("Credenciales inválidas"));
    }
}

