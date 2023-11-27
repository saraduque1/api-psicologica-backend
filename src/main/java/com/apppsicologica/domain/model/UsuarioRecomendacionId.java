package com.apppsicologica.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioRecomendacionId implements Serializable {
    private Long idUsuario;
    private Long idRecomendacion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRecomendacionId that = (UsuarioRecomendacionId) o;
        return Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idRecomendacion, that.idRecomendacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idRecomendacion);
    }
}
