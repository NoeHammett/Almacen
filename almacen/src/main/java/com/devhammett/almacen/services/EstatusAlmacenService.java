package com.devhammett.almacen.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.devhammett.almacen.models.EstatusAlmacenModel;
import com.devhammett.almacen.repositories.EstatusAlmacenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstatusAlmacenService {

    @Autowired 
    EstatusAlmacenRepository estatusAlmacenRepository;

    //Add an Estatus Almacen
    public String addEstatusAlmacen(EstatusAlmacenModel estatusAlmacen){
        try{
            estatusAlmacenRepository.save(estatusAlmacen);
            return "Estatus Agregado Correctamente";
        }catch(Exception e){
            return "Error al agregar Estatus \n"+e.getMessage();
        }
    }
    //Get All Estatus
    public ArrayList<EstatusAlmacenModel> getAllEstatusAlmacen(){
        return (ArrayList<EstatusAlmacenModel>) estatusAlmacenRepository.findAll();
    }

    //Update Estatus Almacen
    @Transactional
    public String updateEstatusAlmacen(EstatusAlmacenModel estatusAlmacenUpdate, Long id_estatus_almacen){
        EstatusAlmacenModel estatusAlmacen = estatusAlmacenRepository.findById(id_estatus_almacen).orElseThrow(() -> new RuntimeException("Estatus no encontrado"));
        
        try{
            if(estatusAlmacenUpdate.getNombre_estatus_almacen()!=null && estatusAlmacenUpdate.getNombre_estatus_almacen()!=""){
                estatusAlmacen.setNombre_estatus_almacen(estatusAlmacenUpdate.getNombre_estatus_almacen());
            }
            return "Estatus Actualizado Correctamente";
        }catch (Exception e) {
            return "Error al actualizar Estatus \n"+e.getMessage();
        }
    }
    
}
