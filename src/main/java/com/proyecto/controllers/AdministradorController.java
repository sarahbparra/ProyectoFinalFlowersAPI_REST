package com.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.services.AdministradorService;

import lombok.RequiredArgsConstructor;

//En lugar de controller usamos un restcontroller
//En una api rest se gestiona un recurso y en dependencias de http sera la peticion u otra
@RestController
@RequestMapping("/administradores") 
@RequiredArgsConstructor
public class AdministradorController {
    
    @Autowired
    private AdministradorService administradorService;
    
}
