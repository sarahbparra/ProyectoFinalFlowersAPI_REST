package com.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

import com.proyecto.dao.ProveedorDao;
import com.proyecto.entities.Proveedor;
@Service //para llamar a los beans 

public class ProveedorServiceImpl implements ProveedorService {

    //Como los metodos van a llamar al DAO entonces tengo que insertarlo aqui con el @Autowired para que el Spring lo "inserta"
    //el Autowired resuelve una dependencia, tambien se puede resolver por constructores 
    @Autowired 
    private ProveedorDao proveedorDao;

    @Override
    public List<Proveedor> findAll(Sort sort) {
        return proveedorDao.findAll(sort);
    }

    @Override
    public Page<Proveedor> findAll(Pageable pageable) {
        return proveedorDao.findAll(pageable);
    }

    @Override
    public Proveedor findById(long id) {
        return proveedorDao.findById(id);
      
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorDao.save(proveedor);
        
    }

    @Override
    public void delete(Proveedor proveedor) {
        proveedorDao.delete(proveedor);

    }

}