package com.proyecto.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedidos")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Pedido implements Serializable{
    
    private static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; 

    private String codigoPedido; 

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPedido; 

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaSalida; 

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) 
    private Comprador comprador; 

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pedido")
    private List<Producto> productos; 



}
