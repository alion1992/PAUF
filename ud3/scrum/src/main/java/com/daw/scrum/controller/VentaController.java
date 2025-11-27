package com.daw.scrum.controller;

import com.daw.scrum.dto.UsuarioDTO;
import com.daw.scrum.dto.VentaDTO;
import com.daw.scrum.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController
{
    @Autowired
    private VentasService ventasService;

    @PostMapping("api/insertarVenta")
    public VentaDTO insertarVenta(@RequestBody VentaDTO ventaDTO){
        System.out.println("DD");
        return ventasService.insertarVenta(ventaDTO);
    }

    @GetMapping("/api/listaVentas")
    public String listar() {
        return "holass";
    }

    @GetMapping("/api/obtenerVenta/{id}")
    public VentaDTO obtenerVenta(@PathVariable("id") Long id) {
        return ventasService.obtenerVenta(id);
    }




}
