package com.daw.scrum.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EstadoVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descripcion;

    public EstadoVenta(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public EstadoVenta() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
