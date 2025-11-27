package com.daw.scrum.dto;

import com.daw.scrum.model.EstadoVenta;
import com.daw.scrum.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

public class VentaDTO
{
    private Long id;


    private Date fechaVenta;

    private UsuarioDTO usuario;

    private EstadoVentaDTO estadoVenta;

    public VentaDTO(Long id, Date fechaVenta, UsuarioDTO usuario, EstadoVentaDTO estadoVenta) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.usuario = usuario;
        this.estadoVenta = estadoVenta;
    }

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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public EstadoVentaDTO getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVentaDTO estadoVenta) {
        this.estadoVenta = estadoVenta;
    }
}
