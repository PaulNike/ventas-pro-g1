package com.codigo.msventaspro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "calzado")
@Getter
@Setter
public class Calzado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String talla;
    private BigDecimal valorUnitario;
    private BigDecimal precioUnitario;
    private int stock;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
