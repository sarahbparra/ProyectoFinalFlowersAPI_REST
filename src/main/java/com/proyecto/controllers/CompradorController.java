package com.proyecto.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entities.Comprador;
import com.proyecto.services.CompradorService;

@RestController
@RequestMapping("/compradores")

public class CompradorController {

    @Autowired 
    private CompradorService compradorService; 

    /**Método para recuperar un listado de compradores 
     * 
     */

     @GetMapping 
     public ResponseEntity<List<Comprador>> findAll(@RequestParam(name = "page", required = false) Integer page, 
     @RequestParam(name = "size", required = false) Integer size){

        ResponseEntity<List<Comprador>> responseEntity = null; 

        List<Comprador> compradores = new ArrayList<>(); 

        Sort sortById = Sort.by("id"); 

        if(page != null && size != null){

            try {

                Pageable pageable = PageRequest.of(page, size, sortById); 
                Page<Comprador> compradoresPaginados = compradorService.findAll(pageable); 
                compradores = compradoresPaginados.getContent(); 

                responseEntity = new ResponseEntity<List<Comprador>>(compradores, HttpStatus.OK); 
            

            } catch (Exception e) {
                
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
            }
            
        } else {

            try {
                
                compradores = compradorService.findAll(sortById); 

                responseEntity = new ResponseEntity<List<Comprador>>(compradores, HttpStatus.OK); 
            } catch (Exception e) {
                
                responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT); 
            }
        }


        return responseEntity; 

     }

     /**Método para recuperar comprador por id  */

     @GetMapping("/{id}")

     public ResponseEntity<Map<String, Object>> findById(@PathVariable)
    
}
