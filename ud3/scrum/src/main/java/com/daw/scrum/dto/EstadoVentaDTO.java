package com.daw.scrum.dto;

public class EstadoVentaDTO {

    private Long id;

    private String descripcion;

    public EstadoVentaDTO(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public EstadoVentaDTO() {

    }

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

