package com.proyecto.controllers;

import java.util.List;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entities.Administrador;
import com.proyecto.services.AdministradorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

//En lugar de controller usamos un restcontroller
//En una API Rest se gestiona un recurso y en dependencias de http sera la peticion u otra
@RestController
@RequestMapping("/administradores")
@RequiredArgsConstructor
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    /**
     * Obtener todos los administradores. En este caso, al ser podos
     * administradores, hemos decidido que una lista es suficiente, sin necesidad de
     * paginado o tamaño
     */
    @GetMapping
    public ResponseEntity<List<Administrador>> findAll() {
        ResponseEntity<List<Administrador>> responseEntity = null;
        List<Administrador> administradores = administradorService.findAll();

        if (administradores.isEmpty()) {
            try {
                administradores = administradorService.findAll();
                responseEntity = new ResponseEntity<List<Administrador>>(administradores, HttpStatus.OK);
            } catch (Exception e) {
                responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } else {
            responseEntity = ResponseEntity.ok(administradores);
        }

        return responseEntity;
    }

    // Obtener un administrador por su id
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable(name = "id") Long id) {
        Map<String, Object> responseAsMap = new HashMap<>();
        ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<>(HttpStatus.OK);

        try {
            Administrador administrador = administradorService.findById(id);

            if (administrador != null) {
                String successMessage = "Se ha encontrado el administrador con id: " + id;
                responseAsMap.put("mensaje", successMessage);
                responseAsMap.put("administrador", administrador);
                responseEntity = new ResponseEntity<>(responseAsMap, HttpStatus.OK);
            } else {
                String errorMessage = "No se ha podido encontrar el administrador con id: " + id;
                responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
                responseAsMap.put("errores", errorMessage);
            }
        } catch (Exception e) {
            String errorGrave = "Error grave";
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            responseAsMap.put("error", errorGrave);
        }

        return responseEntity;
    }

    // Crear un nuevo administrador
    @PostMapping
    @Transactional
    public ResponseEntity<Map<String, Object>> insert(@Valid @RequestBody Administrador administrador,
            BindingResult result) {
        Map<String, Object> responseAsMap = new HashMap<>();

        // Primero hay que comprobar si hay errores en el administrador recibido
        if (result.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            // Se recorren todos los errores y se agregan a la lista
            for (ObjectError error : result.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            responseAsMap.put("errores", errorMessages);
            // Se devuelve la respuesta con los errores y un código de estado BAD REQUEST
            return new ResponseEntity<>(responseAsMap, HttpStatus.BAD_REQUEST);
        }

        try {
            // Se guarda el administrador en la base de datos
            Administrador nuevoAdministrador = administradorService.save(administrador);
            // Se crea la respuesta con un mensaje de éxito y el administrador creado
            String mensaje = "El administrador se ha creado correctamente";
            responseAsMap.put("mensaje", mensaje);
            responseAsMap.put("administrador", nuevoAdministrador);
            // Se devuelve la respuesta con el administrador creado y un código de estado
            // CREATED
            return new ResponseEntity<>(responseAsMap, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            // Si ocurre una excepción al guardar el administrador, se devuelve una
            // respuesta con un mensaje de error
            // y un código de estado INTERNAL SERVER ERROR
            String errorGrave = "Se ha producido un error grave, y la causa más probable puede ser: "
                    + e.getMostSpecificCause();
            responseAsMap.put("errorGrave", errorGrave);
            return new ResponseEntity<>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // // Actualizar un administrador existente
    // @PutMapping("/{id}")
    // public ResponseEntity<Administrador> update(@PathVariable("id") long id, @RequestBody Administrador administrador) {
    //     Administrador administradorExistente = administradorService.findById(id);
    //     if (administradorExistente != null) {
    //         administrador.setId(id);
    //         Administrador administradorActualizado = administradorService.save(administrador);
    //         return ResponseEntity.ok(administradorActualizado);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    // Eliminar un administrador por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        Administrador administrador = administradorService.findById(id);
        if (administrador != null) {
            administradorService.delete(administrador);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
