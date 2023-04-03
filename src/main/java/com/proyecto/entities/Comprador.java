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
@Table(name = "compradores")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Comprador implements Serializable{
    
    public static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; 

    private String nombre; 
    private String primerApellido; 
    private String segundoApellido; 
    private String correo; 
    private String telefono; 

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento; 

    private Genero genero; 
    public enum Genero {
        HOMBRE, MUJER, OTRO
    }

   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) 
   private Proveedor proveedor;  

   @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "comprador")
   List<Pedido> pedidos; 

   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) 
   private Administrador administrador; 
    
}
