package com.daw.scrum.service;


import com.daw.scrum.dto.VentaDTO;
import com.daw.scrum.model.EstadoVenta;
import com.daw.scrum.model.Usuario;
import com.daw.scrum.model.Venta;
import com.daw.scrum.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    public VentaDTO insertarVenta(VentaDTO ventaDTO){
        Usuario user = new Usuario();
        user.setId(ventaDTO.getUsuario().getId());
        EstadoVenta estadoVenta = new EstadoVenta();
        estadoVenta.setDescripcion(ventaDTO.getEstadoVenta().getDescripcion());

        Venta venta = new Venta(null, ventaDTO.getFechaVenta(),user,estadoVenta);
        venta = ventasRepository.save(venta);
        ventaDTO.setId(venta.getId());
        ventaDTO.getEstadoVenta().setId(venta.getEstadoVenta().getId());

        return ventaDTO;
    }
}
