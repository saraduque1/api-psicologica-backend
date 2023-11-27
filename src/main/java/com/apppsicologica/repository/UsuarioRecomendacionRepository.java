package com.apppsicologica.repository;

import com.apppsicologica.domain.model.UsuarioRecomendacion;
import com.apppsicologica.domain.model.UsuarioRecomendacionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRecomendacionRepository extends JpaRepository<UsuarioRecomendacion, UsuarioRecomendacionId> {
}
