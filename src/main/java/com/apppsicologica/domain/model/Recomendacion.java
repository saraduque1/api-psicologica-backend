package com.apppsicologica.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Recomendaciones")
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recomendacion")
    private Long idRecomendacion;

    @Column(nullable = false)
    private String recomendacion;

    @ManyToMany(mappedBy = "recomendaciones")
    private Set<Usuario> usuarios = new HashSet<>();

}
