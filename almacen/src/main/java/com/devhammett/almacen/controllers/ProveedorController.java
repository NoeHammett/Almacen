package com.devhammett.almacen.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.devhammett.almacen.models.ProveedorModel;
import com.devhammett.almacen.services.ProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/proveedor", produces = "application/json")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @PostMapping("/addProveedor")
    public String addProveedor(@RequestBody ProveedorModel proveedor){
        return proveedorService.addProveedor(proveedor);
    }
    
    @GetMapping("/getProveedorById/{id_proveedor}")
    public ProveedorModel getProveedorById(@PathVariable("id_proveedor") Long id_proveedor) {
        return proveedorService.getProveedorById(id_proveedor);
    }

    @GetMapping("/getProveedorByNombre/{nombre_proveedor}")
    public Optional<ProveedorModel> getProveedorByNombre(@PathVariable("nombre_proveedor")String nombre_proveedor) {
          return proveedorService.getProveedorByNombre(nombre_proveedor);
    }
    
    @GetMapping("/getAllProveedores")
    public ArrayList<ProveedorModel> getAllProveedores(){
        return (ArrayList<ProveedorModel>) proveedorService.getAllProveedores(); 
    }

    @GetMapping("/getProveedorByEstatus/{id_estatus_proveedor}")
    public ArrayList<ProveedorModel> getProveedorByEstatus(@PathVariable("id_estatus_proveedor") Long id_estatus_proveedor){
        return (ArrayList<ProveedorModel>) proveedorService.getProveedorByEstatus(id_estatus_proveedor);
    }

    @PutMapping("/updateProveedor/{id_proveedor}")
    public String updateProveedor(@PathVariable("id_proveedor") Long id_proveedor, @RequestBody ProveedorModel proveedor){
        return proveedorService.updateProveedor(proveedor,id_proveedor);
    }
}
