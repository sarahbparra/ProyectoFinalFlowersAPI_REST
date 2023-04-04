package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entities.Administrador;

  
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface AdministradorDao extends JpaRepository<Administrador, Long>{

/**
 
 * La interfaz extiende la interfaz JpaRepository, que proporciona métodos
 * básicos para acceder a la base de datos relacionales utilizando JPA (Java
 * Persistence API). La entidad administrador es la entidad gestionada por esta
 * capa y Integer es el tipo de datos del identificador de la entidad
 * Administrador en la base de datos.
 * 
 * No se proporciona ninguna implementación explícita para los métodos CRUD, ya
 * que Spring Data JPA se encarga de crear la implementación en tiempo de
 * ejecución en función de los nombres de los métodos definidos en esta
 * interfaz. 
 */

//En principio no haría falta. COMPROBAR
    
//     /**Método que devuelve lista de administradors ordenados */
// @Query(value = "select p from Producto p left join fetch p.administrador")
// public List<Producto> findAll(Sort sort);

// /**Método que devuelve lista de productos paginados */
// @Query(value = "select p from Producto p left join fetch p.administrador",
// countQuery = "select count(p) from Producto p left join p.administrador")
// public Page<Producto> findAll(Pageable pageable);

// /**Método que recupera producto por el ID */
// @Query(value = "select p from Producto p left join fetch p.administrador where p.id = :id")
// public Producto findById(long id);


}
