package com.daw.scrum.model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class EstadoVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descripcion;

    @OneToMany(mappedBy = "estadoVenta", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Venta> ventas =  new HashSet<>();

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
