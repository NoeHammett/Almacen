package com.devhammett.almacen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="estatus_usuario")
public class EstatusUsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_estatus_usuario;

    private String nombre_estatus_usuario;
    
    public EstatusUsuarioModel() {
    }
    
    public EstatusUsuarioModel(Long id_estatus_usuario, String nombre_estatus_usuario) {
        this.id_estatus_usuario = id_estatus_usuario;
        this.nombre_estatus_usuario = nombre_estatus_usuario;
    }

    public Long getId_estatus_usuario() {
        return this.id_estatus_usuario;
    }

    public void setId_estatus_usuario(Long id_estatus_usuario) {
        this.id_estatus_usuario = id_estatus_usuario;
    }

    public String getNombre_estatus_usuario() {
        return this.nombre_estatus_usuario;
    }

    public void setNombre_estatus_usuario(String nombre_estatus_usuario) {
        this.nombre_estatus_usuario = nombre_estatus_usuario;
    }

}
