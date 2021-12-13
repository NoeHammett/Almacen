package com.devhammett.almacen.services;

import java.util.ArrayList;
import java.util.Optional;

import com.devhammett.almacen.models.UsuarioModel;
import com.devhammett.almacen.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired 
    UsuarioRepository usuarioRepository;

    public String addUsuario(UsuarioModel usuario){
        usuarioRepository.save(usuario);
        return "Usuario agregado";
    }

    public UsuarioModel getUsuarioById(Long id_usuario){
        try{  
            return usuarioRepository.findById(id_usuario).get();
        }catch(Exception e){
            return null;
        }
    }
    
    public ArrayList<UsuarioModel> getUsuarioEstatus(Long id_estatus_usuario){
        try{  
            return (ArrayList<UsuarioModel>) usuarioRepository.findUsuarioByIdEstatus(id_estatus_usuario);
        }catch(Exception e){
            return null;
        }
    }

}