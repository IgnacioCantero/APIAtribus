package com.atribus.Atribus.security;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long id;

    private String nombre;
    private String email;
    private String password;
}
