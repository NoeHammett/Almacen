package com.devhammett.almacen.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.devhammett.almacen.models.AlmacenModel;
import com.devhammett.almacen.repositories.AlmacenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlmacenService {
    
    @Autowired 
    AlmacenRepository almacenRepository;

    //Save Almacen
    public String addAlmacen(AlmacenModel almacen){
        try{
            almacenRepository.save(almacen);
            return "Almacen agregado";
        }catch(Exception e){
            return "Error al agregar almacen \n"+ e.getMessage();
        }
    }

    //Get Almacen By ID
    public AlmacenModel getAlmacenById(Long id_almacen){
        return almacenRepository.findById(id_almacen).get();
    }

    //Get Almacen By Estatus
    public ArrayList<AlmacenModel> getAlmacenByEstatus (Long id_estatus){
        return almacenRepository.fyndByEstatus(id_estatus);
    }

    //Get All Almacenes
    public ArrayList<AlmacenModel> getAllAlmacenes(){
        return (ArrayList<AlmacenModel>) almacenRepository.findAll();
    }

    //Update Almacen
    @Transactional
    public String updateAlmacen(AlmacenModel almacenUpdate, Long id_almacen){
        AlmacenModel almacen = almacenRepository.findById(id_almacen).orElseThrow(() -> new RuntimeException("Almacen no encontrado"));

        try{
            if(almacenUpdate.getNombre_almacen()!= null && almacenUpdate.getNombre_almacen() != ""){
                almacen.setNombre_almacen(almacenUpdate.getNombre_almacen());
            }
            if(almacenUpdate.getDireccion_almacen()!= null && almacenUpdate.getDireccion_almacen()!=""){
                almacen.setDireccion_almacen(almacenUpdate.getDireccion_almacen());
            }
            if(almacenUpdate.getEmail_almacen()!=null && almacenUpdate.getEmail_almacen()!=""){
                almacen.setEmail_almacen(almacenUpdate.getEmail_almacen());
            }
            if(almacenUpdate.getTelefono_almacen()!=null){
                almacen.setTelefono_almacen(almacenUpdate.getTelefono_almacen());
            }
            if(almacenUpdate.getCodigo_postal_almacen()!=null){
                almacen.setCodigo_postal_almacen(almacenUpdate.getCodigo_postal_almacen());
            }
            if(almacenUpdate.getId_estatus_almacen()!=null){
                almacen.setId_estatus_almacen(almacenUpdate.getId_estatus_almacen());
            }
            return "Almacen actualizado";
        }catch (Exception e) {
            return "Error al actualizar almacen \n"+ e.getMessage();
        }

    }

}
