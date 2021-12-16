package com.devhammett.almacen.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import com.devhammett.almacen.models.UsuarioModel;
import com.devhammett.almacen.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired 
    UsuarioRepository usuarioRepository;

    public String addUsuario(UsuarioModel usuario){
        Optional<UsuarioModel> usuarioEmail = usuarioRepository.findUsuarioByEmail(usuario.getEmail_usuario());
        Optional<UsuarioModel> usuarioNickname = usuarioRepository.findUsuarioByNickname(usuario.getNickname_usuario());
        if(usuarioEmail.isPresent()){
            throw new IllegalStateException("El Email ya ha sido registrado previamente");
        }else if(usuarioNickname.isPresent()){
            throw new IllegalStateException("El Nickname ya ha sido registrado previamente");
        }else{
            usuarioRepository.save(usuario);
            return "Usuario agregado";
        }    
    }

    public UsuarioModel getUsuarioById(Long id_usuario){
        try{  
            return usuarioRepository.findById(id_usuario).get();
        }catch(Exception e){
            return null;
        }
    }
    public Optional<UsuarioModel> getUsuarioByEmail(String email_usuario){
        return usuarioRepository.findUsuarioByEmail(email_usuario);
    }  

    
    public ArrayList<UsuarioModel> getUsuarioEstatus(Long id_estatus_usuario){
        try{  
            return (ArrayList<UsuarioModel>) usuarioRepository.findUsuarioByIdEstatus(id_estatus_usuario);
        }catch(Exception e){
            return null;
        }
    }

    @Transactional
    public String updateUsuario(UsuarioModel usuarioUpdate, Long id_usuario){
        UsuarioModel usuario = usuarioRepository.findById(id_usuario).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        try{
            if(usuarioUpdate.getNombre_usuario()!= null && usuario.getNombre_usuario() != ""){
                usuario.setNombre_usuario(usuarioUpdate.getNombre_usuario());
            }
            if(usuarioUpdate.getPrimer_apellido_usuario() !=null && usuario.getPrimer_apellido_usuario() != ""){
                usuario.setPrimer_apellido_usuario(usuarioUpdate.getPrimer_apellido_usuario());
            }
            if(usuarioUpdate.getSegundo_apellido_usuario() != null && usuario.getSegundo_apellido_usuario() != ""){
                usuario.setSegundo_apellido_usuario(usuarioUpdate.getSegundo_apellido_usuario());
            }
            if(usuarioUpdate.getNickname_usuario() != null && usuario.getNickname_usuario() != ""){
                usuario.setNickname_usuario(usuarioUpdate.getNickname_usuario());
            }
            if(usuarioUpdate.getDireccion_usuario() != null && usuario.getDireccion_usuario() != ""){
                usuario.setDireccion_usuario(usuarioUpdate.getDireccion_usuario());
            }
            if(usuarioUpdate.getId_estatus_usuario() !=null){
                usuario.setId_estatus_usuario(usuarioUpdate.getId_estatus_usuario());
            }
            return "Usuario actualizado";
        }catch (Exception e) {
            return "Error al actualizar \n"+ e.getMessage();
        }
    }

}