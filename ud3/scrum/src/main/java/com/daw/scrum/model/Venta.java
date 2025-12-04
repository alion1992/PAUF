package com.daw.scrum.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estadoVenta_id",nullable = false)
    private EstadoVenta estadoVenta;

    @ManyToMany
    @JoinTable(
            name = "venta_producto",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private Set<Producto> productos = new HashSet<>();

    public Venta(Long id, Date fechaVenta, Usuario usuario, EstadoVenta estadoVenta) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.usuario = usuario;
        this.estadoVenta = estadoVenta;
    }

    public Venta() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
