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
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private java.sql.Date fechaNacimiento;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private Double estatura;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String contrasena;

    @ManyToMany
    @JoinTable(
            name = "Respuestas",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_pregunta")
    )
    private Set<Pregunta> preguntas = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Usuarios_Recomendaciones",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_recomendacion")
    )
    private Set<Recomendacion> recomendaciones = new HashSet<>();

}
