package com.daw.scrum.repository;

import com.daw.scrum.dto.UsuarioDTO;
import com.daw.scrum.dto.views.UsuarioView;
import com.daw.scrum.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//import org.springframework.data.jpa.r

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByEmail(String email);

    @Query(value = "SELECT id, nombre, email FROM usuario", nativeQuery = true)
    List<UsuarioView> listarUsuarios();

    @Query(value = "SELECT id, nombre, email FROM usuario where nombre = :nombre and email = :email", nativeQuery = true)
    List<UsuarioView> listarUsuariosPorNombreYEmail(@Param("nombre") String nombre, @Param("email") String email);
}