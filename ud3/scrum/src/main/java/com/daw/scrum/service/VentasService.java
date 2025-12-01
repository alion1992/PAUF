package com.daw.scrum.service;


import com.daw.scrum.dto.UsuarioDTO;
import com.daw.scrum.dto.VentaDTO;
import com.daw.scrum.model.EstadoVenta;
import com.daw.scrum.model.Usuario;
import com.daw.scrum.model.Venta;
import com.daw.scrum.repository.EstadoVentaRepository;
import com.daw.scrum.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private EstadoVentaRepository estadoVentaRepository;


    public VentaDTO insertarVenta(VentaDTO ventaDTO){
        Usuario user = new Usuario();
        user.setId(ventaDTO.getUsuario().getId());
        EstadoVenta estadoVenta = new EstadoVenta();
        if (null != ventaDTO.getEstadoVenta().getId()) {
            estadoVenta = estadoVentaRepository.findById(ventaDTO.getEstadoVenta().getId()).orElse(null);
        } else {
            estadoVenta.setDescripcion("Sin definir");
        }

        Venta venta = new Venta(null, ventaDTO.getFechaVenta(),user,estadoVenta);
        venta = ventasRepository.save(venta);
        ventaDTO.setId(venta.getId());
        ventaDTO.getEstadoVenta().setId(venta.getEstadoVenta().getId());

        return ventaDTO;
    }

    public VentaDTO obtenerVenta(Long id){
        Venta venta = ventasRepository.findById(id).orElse(null);

        if (null != venta){
            UsuarioDTO userDto = new UsuarioDTO(venta.getUsuario().getId(),venta.getUsuario().getNombre(), venta.getUsuario().getEmail(), venta.getUsuario().getDireccion());

            return new VentaDTO(null,venta.getFechaVenta(),userDto,null);
        } else {
            return null;
        }

    }
}
