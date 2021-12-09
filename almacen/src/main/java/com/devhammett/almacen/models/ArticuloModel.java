package com.devhammett.almacen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articulo")
public class ArticuloModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_articulo;


    private String nombre_articulo;
    private String descripcion_articulo;
    private Double precio;
    private Long cantidad_stock;
    private Long id_categoria;


    public ArticuloModel() {
    }

    public ArticuloModel(Long id_articulo, String nombre_articulo, String descripcion_articulo, Double precio, Long cantidad_stock, Long id_categoria) {
        this.id_articulo = id_articulo;
        this.nombre_articulo = nombre_articulo;
        this.descripcion_articulo = descripcion_articulo;
        this.precio = precio;
        this.cantidad_stock = cantidad_stock;
        this.id_categoria = id_categoria;
    }


    public Long getId_articulo() {
        return this.id_articulo;
    }

    public void setId_articulo(Long id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre_articulo() {
        return this.nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public String getDescripcion_articulo() {
        return this.descripcion_articulo;
    }

    public void setDescripcion_articulo(String descripcion_articulo) {
        this.descripcion_articulo = descripcion_articulo;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getCantidad_stock() {
        return this.cantidad_stock;
    }

    public void setCantidad_stock(Long cantidad_stock) {
        this.cantidad_stock = cantidad_stock;
    }

    public Long getId_categoria() {
        return this.id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    
}
