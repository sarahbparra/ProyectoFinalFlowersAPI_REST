package com.proyecto.services;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.proyecto.entities.Proveedor;

public interface ProveedorService  {
    
    public List<Proveedor> findAll(Sort sort);
    public Page<Proveedor> findAll(Pageable pageable);
    public Proveedor findById (long id); 
    public Proveedor save (Proveedor proveedor);
    public void delete(Proveedor proveedor);
}
