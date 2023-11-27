package com.apppsicologica.repository;

import com.apppsicologica.domain.dto.LoginDTO;
import com.apppsicologica.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailAndContrasena(String email, String contrasena);
}

