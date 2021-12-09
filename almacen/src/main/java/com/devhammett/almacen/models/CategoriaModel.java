package com.devhammett.almacen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_categoria;
    
    private String nombre_categoria;
    private String descripcion_categoria;
    private Long anio_categoria;

    public CategoriaModel() {
    }

    public CategoriaModel(Long id_categoria, String nombre_categoria, String descripcion_categoria, Long anio_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.descripcion_categoria = descripcion_categoria;
        this.anio_categoria = anio_categoria;
    }


    public Long getId_categoria() {
        return this.id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return this.nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getDescripcion_categoria() {
        return this.descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    public Long getAnio_categoria() {
        return this.anio_categoria;
    }

    public void setAnio_categoria(Long anio_categoria) {
        this.anio_categoria = anio_categoria;
    }
}