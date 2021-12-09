package com.devhammett.almacen.controllers;

import java.util.ArrayList;

import com.devhammett.almacen.models.AlmacenModel;
import com.devhammett.almacen.services.AlmacenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/almacen", produces = "application/json")
public class AlmacenController {
    
    @Autowired
    AlmacenService almacenService;

    @GetMapping("/getAlmacen/{id_almacen}")
    public AlmacenModel getAlmacenById(@PathVariable("id_almacen") Long id_almacen) {
        return almacenService.getAlmacenById(id_almacen);
    }

    @GetMapping("/getAllAlmacen")
    public ArrayList<AlmacenModel> getAllAlmacen(){
        return almacenService.getAllAlmacenes();
    }

    @GetMapping("/getAlmacenByEstatus/{id_estatus}")
    public ArrayList<AlmacenModel> getAlmacenByEstatus(@PathVariable("id_estatus") Long id_estatus){
        return almacenService.getAlmacenByEstatus(id_estatus);
    }

    @PostMapping("/addAlmacen")
    public String addAlmacen(@RequestBody AlmacenModel almacen){
        return almacenService.addAlmacen(almacen);
    }

    @PutMapping("/updateAlmacen/{id_almacen}")
    public String updateAlmacen(@RequestBody AlmacenModel almacen,@PathVariable("id_almacen") Long id_almacen){
        return almacenService.updateAlmacen(almacen, id_almacen);
    }
}
