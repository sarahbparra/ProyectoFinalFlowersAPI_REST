package com.proyecto.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.proyecto.entities.Comprador;

public interface CompradorService {
    
    public List<Comprador> findAll(Sort sort); 
    public Page<Comprador> findAll(Pageable pageable); 
    public Comprador findById(long idComprador); 
    public Comprador save(Comprador comprador); 
    public void deleteById(int idComprador); 
    public void delete(Comprador comprador); 
    // public Comprador findByIdPedido (int idPedido); 
    // public void deleteByAdministrador(Administrador administrador);

}
