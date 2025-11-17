package com.daw.scrum.repository;

import com.daw.scrum.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.r

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}