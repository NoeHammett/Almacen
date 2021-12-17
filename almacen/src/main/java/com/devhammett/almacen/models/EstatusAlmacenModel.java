package com.devhammett.almacen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estatus_almacen")
public class EstatusAlmacenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_estatus_almacen;

    private String nombre_estatus_almacen;

    public EstatusAlmacenModel() {
    }

    public EstatusAlmacenModel(Long id_estatus_almacen, String nombre_estatus_almacen) {
        this.id_estatus_almacen = id_estatus_almacen;
        this.nombre_estatus_almacen = nombre_estatus_almacen;
    }

    public Long getId_estatus_almacen() {
        return this.id_estatus_almacen;
    }

    public void setId_estatus_almacen(Long id_estatus_almacen) {
        this.id_estatus_almacen = id_estatus_almacen;
    }

    public String getNombre_estatus_almacen() {
        return this.nombre_estatus_almacen;
    }

    public void setNombre_estatus_almacen(String nombre_estatus_almacen) {
        this.nombre_estatus_almacen = nombre_estatus_almacen;
    }

    
}
