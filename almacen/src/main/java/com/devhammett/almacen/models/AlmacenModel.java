package com.devhammett.almacen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "almacen")
public class AlmacenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_almacen;
    
    private String nombre_almacen;
    private String direccion_almacen;
    private String email_almacen;
    private Long telefono_almacen;
    private Long codigo_postal_almacen;
    private Long id_estatus_almacen;

    public AlmacenModel() {
    }

    public AlmacenModel(Long id_almacen, String nombre_almacen, String direccion_almacen, String email_almacen, Long telefono_almacen, Long codigo_postal_almacen, Long id_estatus_almacen) {
        this.id_almacen = id_almacen;
        this.nombre_almacen = nombre_almacen;
        this.direccion_almacen = direccion_almacen;
        this.email_almacen = email_almacen;
        this.telefono_almacen = telefono_almacen;
        this.codigo_postal_almacen = codigo_postal_almacen;
        this.id_estatus_almacen = id_estatus_almacen;
    }


    public Long getId_almacen() {
        return this.id_almacen;
    }

    public void setId_almacen(Long id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getNombre_almacen() {
        return this.nombre_almacen;
    }

    public void setNombre_almacen(String nombre_almacen) {
        this.nombre_almacen = nombre_almacen;
    }

    public String getDireccion_almacen() {
        return this.direccion_almacen;
    }

    public void setDireccion_almacen(String direccion_almacen) {
        this.direccion_almacen = direccion_almacen;
    }

    public String getEmail_almacen() {
        return this.email_almacen;
    }

    public void setEmail_almacen(String email_almacen) {
        this.email_almacen = email_almacen;
    }

    public Long getTelefono_almacen() {
        return this.telefono_almacen;
    }

    public void setTelefono_almacen(Long telefono_almacen) {
        this.telefono_almacen = telefono_almacen;
    }

    public Long getCodigo_postal_almacen() {
        return this.codigo_postal_almacen;
    }

    public void setCodigo_postal_almacen(Long codigo_postal_almacen) {
        this.codigo_postal_almacen = codigo_postal_almacen;
    }


    public Long getId_estatus_almacen() {
        return this.id_estatus_almacen;
    }

    public void setId_estatus_almacen(Long id_estatus_almacen) {
        this.id_estatus_almacen = id_estatus_almacen;
    }
    
    
}
