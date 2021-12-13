package com.devhammett.almacen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_usuario;

    private String nombre_usuario;
    private String primer_apellido_usuario;
    private String segundo_apellido_usuario;
    private String email_usuario;
    private String nickname_usuario;
    private String password_usuario;
    private String direccion_usuario;
    
    private Long id_estatus_usuario;

    public UsuarioModel() {
    }


    public UsuarioModel(Long id_usuario, String nombre_usuario, String primer_apellido_usuario, String segundo_apellido_usuario, String email_usuario, String nickname_usuario, String password_usuario, String direccion_usuario, Long id_estatus_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.primer_apellido_usuario = primer_apellido_usuario;
        this.segundo_apellido_usuario = segundo_apellido_usuario;
        this.email_usuario = email_usuario;
        this.nickname_usuario = nickname_usuario;
        this.password_usuario = password_usuario;
        this.direccion_usuario = direccion_usuario;
        this.id_estatus_usuario = id_estatus_usuario;
    }


    public Long getId_usuario() {
        return this.id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return this.nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPrimer_apellido_usuario() {
        return this.primer_apellido_usuario;
    }

    public void setPrimer_apellido_usuario(String primer_apellido_usuario) {
        this.primer_apellido_usuario = primer_apellido_usuario;
    }

    public String getSegundo_apellido_usuario() {
        return this.segundo_apellido_usuario;
    }

    public void setSegundo_apellido_usuario(String segundo_apellido_usuario) {
        this.segundo_apellido_usuario = segundo_apellido_usuario;
    }

    public String getEmail_usuario() {
        return this.email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getNickname_usuario() {
        return this.nickname_usuario;
    }

    public void setNickname_usuario(String nickname_usuario) {
        this.nickname_usuario = nickname_usuario;
    }

    public String getPassword_usuario() {
        return this.password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public String getDireccion_usuario() {
        return this.direccion_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public Long getId_estatus_usuario() {
        return this.id_estatus_usuario;
    }

    public void setId_estatus_usuario(Long id_estatus_usuario) {
        this.id_estatus_usuario = id_estatus_usuario;
    }


}
