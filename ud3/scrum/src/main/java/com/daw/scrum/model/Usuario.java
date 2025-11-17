package com.daw.scrum.model;


import jakarta.persistence.*;

@Entity
@Table(name ="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private String hola;
    private String pruebaClase;

    public Usuario(Long id, String nombre, String email, String password,String hola,String pruebaClase) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.hola = hola;
        this.pruebaClase = pruebaClase;
    }

    public Usuario(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHola() {
        return hola;
    }

    public void setHola(String hola) {
        this.hola = hola;
    }

    public String getPruebaClase() {
        return pruebaClase;
    }

    public void setPruebaClase(String pruebaClase) {
        this.pruebaClase = pruebaClase;
    }
}
