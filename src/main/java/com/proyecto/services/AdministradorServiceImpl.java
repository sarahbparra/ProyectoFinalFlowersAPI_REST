package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.AdministradorDao;
import com.proyecto.entities.Administrador;

/**
 * 
 * La clase AdministradorServiceImpl implementa la interfaz AdministradorService y proporciona la lógica de negocio para la entidad Administrador.
 * 
 * La anotación @Service indica que esta clase es un servicio y debe ser manejado por Spring para su gestión en tiempo de ejecución.
 * 
 * Los métodos de esta clase se encargan de realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) en la entidad Administrador, a través del uso de la interfaz
 * AdministradorDao.

 */
@Service
public class AdministradorServiceImpl implements AdministradorService {

    /** Creamos la variable de tipo Dao para poder inyectarle la capa DAO, puede resolverse con un @Autowire o mediante constructor: */
    
    @Autowired
    private AdministradorDao administradorDao;

    /**
     * 
     * Este método devuelve una lista de todos los administradores en la base de
     * datos.
     * 
     * @return List<Administrador> - una lista de todos los administradores.
     */
    @Override
    public List<Administrador> findAll() {
        return administradorDao.findAll();
    }

    /**
     * 
     * Este método encuentra y devuelve un administrador en la base de datos por su
     * ID.
     * 
     * @param id - el ID del administrador a buscar.
     * @return Administrador - el administrador encontrado, si existe.
     */
    @Override
    public Administrador findById(long id) {
        return administradorDao.findById(id).get();
    }

    /**
     * 
     * Este método guarda un administrador en la base de datos.
     * 
     * @param Administrador - el administrador a guardar.
     */
    @Override
    public Administrador save(Administrador Administrador) {
       return administradorDao.save(Administrador);
    }

    /**
     * 
     * Este método elimina un administrador de la base de datos.
     * 
     * @param Administrador - el administrador a eliminar.
     */
    @Override
    public void delete(Administrador Administrador) {
        administradorDao.delete(Administrador);
    }

    
}
