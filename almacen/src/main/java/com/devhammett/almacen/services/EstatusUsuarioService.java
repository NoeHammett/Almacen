package com.devhammett.almacen.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.devhammett.almacen.models.EstatusUsuarioModel;
import com.devhammett.almacen.repositories.EstatusUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstatusUsuarioService {
    
    @Autowired
    EstatusUsuarioRepository estatusUsuarioRepository;

    public String addEstatusUsuario(EstatusUsuarioModel estatusUsuarioModel){
        try{
            estatusUsuarioRepository.save(estatusUsuarioModel);
            return "Se ha registrado correctamente un nuevo estatus de usuario";

        }catch(Exception e){
            return "Error al agregar el estatus de usuario \n" + e.getMessage();
        }
    }

    public ArrayList<EstatusUsuarioModel> getAllEstatusUsuario (){
        return (ArrayList<EstatusUsuarioModel>) estatusUsuarioRepository.findAll();
    }
    
    @Transactional
    public String updateEstatusUsuario (EstatusUsuarioModel estatusUsuarioUpdate, Long id_estatusUsuario){
        EstatusUsuarioModel estatusUsuario = estatusUsuarioRepository.findById(id_estatusUsuario).orElseThrow(() -> new IllegalArgumentException("No existe el estatus"));
        try{
            if(estatusUsuarioUpdate.getNombre_estatus_usuario() !=null && estatusUsuarioUpdate.getNombre_estatus_usuario() !=""){
                estatusUsuario.setNombre_estatus_usuario(estatusUsuarioUpdate.getNombre_estatus_usuario());
            }
            return "Se ha actualizado correctamente el estatus de usuario";
        }catch(Exception e){
            return "Error al actualizar el estatus de usuario \n" + e.getMessage();
        }
    }


}
