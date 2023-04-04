package com.proyecto.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entities.Proveedor;

public interface ProveedorDao extends JpaRepository<Proveedor, Integer>{
    
    
    // Recuperar la lista de proveedores ordenados:
   
    @Query(value = "select p from Proveedor p inner join fetch p.administrador inner join fetch p.productos") 
    public List<Proveedor> findAll(Sort sort);

    // Recuperar listado de proveedores paginados:
    
    @Query(value = "select p from Proveedor p inner join fetch p.administrador inner join fetch p.productos", 
    countQuery = "select count(p) from Proveedor c left join c.administrador left join c.productos")
    public Page<Proveedor> findAll(Pageable pageable);



    // Consulta para recuperar las presentaciones con sus proveedores utilizando HQL se recupera por el id:
    @Query(value = "select p from Proveedor p left join fetch p.administrador left join fetch p.productos where p.id = :id")
    public Proveedor findById(long id);
}

