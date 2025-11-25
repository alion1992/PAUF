package com.daw.scrum.repository;

import com.daw.scrum.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Venta, Long> {
}
