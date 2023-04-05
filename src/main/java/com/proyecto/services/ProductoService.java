package com.proyecto.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.proyecto.entities.Producto;

public interface ProductoService {
    
    public List<Producto> findAll(Sort sort);
    public Page<Producto> findAll(Pageable pageable);
    public Producto findById(long id);
    public Producto save(Producto producto);
    public void delete(Producto producto);

}
