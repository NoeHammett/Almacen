package com.devhammett.almacen.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import com.devhammett.almacen.models.ProveedorModel;
import com.devhammett.almacen.repositories.ProveedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public String addProveedor(ProveedorModel proveedor){
        Optional<ProveedorModel> nombreProveedor = proveedorRepository.findProveedorByNombre(proveedor.getNombre_proveedor());
    
        if(nombreProveedor.isPresent()){
            throw new IllegalStateException("El proveedor ya ha sido registrado previamente");
        }
        proveedorRepository.save(proveedor);
        return "El proveedor ha sido registrado exitosamente";
    }

    public ProveedorModel getProveedorById(Long id_proveedor){
        try{
            return proveedorRepository.findById(id_proveedor).get();
        }catch (Exception e) {
            return null;
        }   
    }
    
    public Optional<ProveedorModel> getProveedorByNombre(String nombre_proveedor){
        return proveedorRepository.findProveedorByNombre(nombre_proveedor);
    }
    
    public ArrayList<ProveedorModel> getAllProveedores(){
        return (ArrayList<ProveedorModel>) proveedorRepository.findAll();
    }

    public ArrayList<ProveedorModel> getProveedorByEstatus(Long id_estatus_proveedor){
        return (ArrayList<ProveedorModel>) proveedorRepository.findProveedorByEstatus(id_estatus_proveedor);
    }

    @Transactional
    public String updateProveedor(ProveedorModel proveedorUpdate, Long id_proveedor){
        ProveedorModel proveedor = proveedorRepository.findById(id_proveedor).orElseThrow(()-> new IllegalStateException("No existe el proveedor"));
        
        try{
            if(proveedorUpdate.getNombre_proveedor()!=null && proveedorUpdate.getNombre_proveedor() !=""){
                proveedor.setNombre_proveedor(proveedorUpdate.getNombre_proveedor());
            }

            return "Proveedor Actualizado Correctamente";
        }catch(Exception e){
            return "Error al actualizar el proveedor "+e.getMessage();
        }
    }
    
}
