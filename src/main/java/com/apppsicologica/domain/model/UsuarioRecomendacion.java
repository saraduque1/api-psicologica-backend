package com.apppsicologica.domain.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Usuarios_Recomendaciones")
public class UsuarioRecomendacion {
    @EmbeddedId
    private UsuarioRecomendacionId id;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("idRecomendacion")
    @JoinColumn(name = "id_recomendacion")
    private Recomendacion recomendacion;

    @Column(name = "fecha_asociacion", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaAsociacion;
}

