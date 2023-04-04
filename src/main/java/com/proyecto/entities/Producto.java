package com.proyecto.entities;

import java.io.Serializable;
import java.time.Year;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Tipo tipo;
    public enum Tipo {
        VINO, QUESO
    }

    private String procedencia;
    private String nombre;
    private double precio;

    //Propiedades exclusivas del vino:
    private double gradosAlcohol;
    private Year yearCosecha;

    @Enumerated(EnumType.STRING)
    private Envejecimiento envejecimiento;
    public enum Envejecimiento {
        JOVEN, CRIANZA, RESERVA, GRAN_RESERVA
    }

    @Enumerated(EnumType.STRING)
    private Color color;
    
    public enum Color {
        TINTO, BLANCO, ROSADO 
    }

    private double volumen;

    //Propiedades exclusivas del queso:
    private double peso;

    @Enumerated(EnumType.STRING)
    private Maduracion maduracion;
    public enum Maduracion {
        SEMICURADO, CURADO, VIEJO
    }

    @Enumerated(EnumType.STRING)
    private ProcedenciaLeche procedenciaLeche;
    public enum ProcedenciaLeche {
        VACA, OVEJA, CABRA, MEZCLA, BUFALA
    }

   @NotNull
    private String imagenProducto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) 
    private Pedido pedido; 

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Presentacion presentacion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Administrador administrador;
    
}
