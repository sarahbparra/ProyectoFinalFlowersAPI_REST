package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.dao.CompradorDao;
import com.proyecto.entities.Comprador;

//Para buscar los beans de los datos 
@Service

public class CompradorServiceImpl implements CompradorService{

    @Autowired
    private CompradorDao compradorDao; 

    @Override
    @Transactional
    public Comprador save(Comprador comprador) {
        
        return compradorDao.save(comprador); 
    }

    @Override
    @Transactional
    public void delete(Comprador comprador) {
        
        compradorDao.delete(comprador);
    }

    @Override
    @Transactional
    public void deleteById(int idComprador) {
        
        compradorDao.deleteById(idComprador);
    }

    @Override
    public List<Comprador> findAll(Sort sort) {
       
        return compradorDao.findAll(sort); 
    }

    @Override
    public Page<Comprador> findAll(Pageable pageable) {
        
        return compradorDao.findAll(pageable); 
    }

    @Override
    public Comprador findById(long idComprador) {
        
        return compradorDao.findById(idComprador); 
    }

    // @Override
    // public Comprador findByIdPedido(int idPedido) {
        
    //     return compradorDao.findByIdPedido(idPedido);  
    // }


    
}
