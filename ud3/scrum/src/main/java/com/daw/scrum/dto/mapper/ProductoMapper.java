package com.daw.scrum.dto.mapper;

import com.daw.scrum.dto.ProductoDTO;
import com.daw.scrum.model.Producto;

public class ProductoMapper {

    public static ProductoDTO toDTO(Producto producto){
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setPrecio(producto.getPrecio());
        dto.setTipoProducto(producto.getTipoProducto());
        dto.setNombre(producto.getNombre());
        return dto;
    }
}
