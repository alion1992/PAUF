package com.daw.scrum.service;

import com.daw.scrum.dto.UsuarioDTO;
import com.daw.scrum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioDTO(u.getId(), u.getNombre(), u.getEmail()))
                .toList();
    }

    public List<UsuarioDTO> obtenerUsuariosPorEmail(String email) {
            return usuarioRepository.findByEmail(email).stream().
                    map(u -> new UsuarioDTO(u.getId(), u.getNombre(), u.getEmail())).toList();
    }
}
