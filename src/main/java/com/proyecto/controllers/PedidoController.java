package com.proyecto.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.entities.Pedido;
import com.proyecto.services.PedidoService;
import com.proyecto.services.ProductoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    private static final Logger LOG = Logger.getLogger("PedidoController");

    @Autowired
    private PedidoService pedidoService;

    //@Autowired
    //private CompradorService compradorService;

    @Autowired
    private ProductoService productoService;


     /* El metodo siguiente devuelve un listado de pedidos */
     @GetMapping("/listar")
     public ResponseEntity <List<Pedido>> findAll() {
         List<Pedido> pedidos = pedidoService.findAll();
        ResponseEntity<List<Pedido>> responseEntity = null;
         //Sort sortByNombre = Sort.by("nombre");

         try {
            responseEntity = new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
         return responseEntity;
     }
}

