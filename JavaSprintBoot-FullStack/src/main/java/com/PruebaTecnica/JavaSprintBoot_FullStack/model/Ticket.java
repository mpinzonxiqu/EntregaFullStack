package com.PruebaTecnica.JavaSprintBoot_FullStack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private String estatus;

    public void setFechaActualizacion(LocalDateTime now) {
    }

    public void setFechaCreacion(LocalDateTime now) {
    }

    // Getters y Setters
}
