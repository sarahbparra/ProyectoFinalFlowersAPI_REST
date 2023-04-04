package com.proyecto.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entities.Producto;

public interface ProductoDao extends JpaRepository<Producto, Long>{
    
    /**Método que devuelve lista de productos ordenados */
@Query(value = "select p from Producto p left join fetch p.administrador")
public List<Producto> findAll(Sort sort);

/**Método que devuelve lista de productos paginados */
@Query(value = "select p from Producto p left join fetch p.administrador",
countQuery = "select count(p) from Producto p left join p.administrador")
public Page<Producto> findAll(Pageable pageable);

/**Método que recupera producto por el ID */
@Query(value = "select p from Producto p left join fetch p.administrador where p.id = :id")
public Producto findById(long id);


}
