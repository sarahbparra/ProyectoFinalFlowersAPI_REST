package com.proyecto.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entities.Comprador;


public interface CompradorDao extends JpaRepository<Comprador, Integer> {

    // Optional<Comprador> findByIdPedido(int idPedido);
    // @Query(value = "select c from Compradoor c left join c.pedidos where p.id = :idPedido")
    // public Comprador findByIdPedido(int idPedido); 

    /**Método que me recupera la lista de compradores ordenados 
     * Serán necesarias dos querys. 
     */

     @Query(value = "select c from Comprador c inner join fetch c.productos left join fetch c.administrador")
     public List<Comprador> findAll(Sort sort); 

     @Query(value = "select c from Comprador c left join fetch c.administrador",
     countQuery = "select count(c) from Comprador c left join c.administrador")
     public Page<Comprador> findAll(Pageable pageable); 

     /** Método que recupere comprador a partir de su id, tal vez lo pueda hacer 
      * a partir de su nombre 
      */

      @Query(value = "select c from Comprador c left join fetch c.administrador where c.id = :id")
    public Comprador findById(long id); 
    

}
