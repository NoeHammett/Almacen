package com.devhammett.almacen.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedor")
public class ProveedorModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_proveedor;
    
    private String nombre_proveedor;
    private String email_proveedor;
    private String direccion_proveedor;
    private Long codigo_postal_proveedor;
    private Long id_estatus_proveedor;

    private Date fecha_registro_proveedor;

    public ProveedorModel() {
    }

    public ProveedorModel(Long id_proveedor, String nombre_proveedor, String email_proveedor, String direccion_proveedor, Long codigo_postal_proveedor, Long id_estatus_proveedor, Date fecha_registro_proveedor) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.email_proveedor = email_proveedor;
        this.direccion_proveedor = direccion_proveedor;
        this.codigo_postal_proveedor = codigo_postal_proveedor;
        this.id_estatus_proveedor = id_estatus_proveedor;
        this.fecha_registro_proveedor = fecha_registro_proveedor;
    }


    public Long getId_proveedor() {
        return this.id_proveedor;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return this.nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getEmail_proveedor() {
        return this.email_proveedor;
    }

    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }

    public String getDireccion_proveedor() {
        return this.direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public Long getCodigo_postal_proveedor() {
        return this.codigo_postal_proveedor;
    }

    public void setCodigo_postal_proveedor(Long codigo_postal_proveedor) {
        this.codigo_postal_proveedor = codigo_postal_proveedor;
    }

    public Long getId_estatus_proveedor() {
        return this.id_estatus_proveedor;
    }

    public void setId_estatus_proveedor(Long id_estatus_proveedor) {
        this.id_estatus_proveedor = id_estatus_proveedor;
    }

    public Date getFecha_registro_proveedor() {
        return this.fecha_registro_proveedor;
    }

    public void setFecha_registro_proveedor(Date fecha_registro_proveedor) {
        this.fecha_registro_proveedor = fecha_registro_proveedor;
    }
}
