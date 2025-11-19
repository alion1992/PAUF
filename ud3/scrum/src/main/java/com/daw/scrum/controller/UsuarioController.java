package com.daw.scrum.controller;
import com.daw.scrum.dto.UsuarioDTO;
import com.daw.scrum.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/api/hola")
    public String hola() {
        return "Hola";
    }

    @GetMapping("/api/adios")
    public String home() {
        return "Adios";
    }

    @GetMapping("/api/listaUsuarios")
    public List<UsuarioDTO> listar() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/api/listarPorEmail/{email}")
    public List<UsuarioDTO> listarPorEmail(@PathVariable("email") String email) {
        System.out.println(email);
        return usuarioService.obtenerUsuariosPorEmail(email);
    }


}

