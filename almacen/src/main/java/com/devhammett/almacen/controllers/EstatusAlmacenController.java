package com.devhammett.almacen.controllers;

import java.util.ArrayList;

import com.devhammett.almacen.models.EstatusAlmacenModel;
import com.devhammett.almacen.services.EstatusAlmacenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/estatusAlmacen", produces = "application/json")
public class EstatusAlmacenController {
    @Autowired
    EstatusAlmacenService estatusAlmacenService;

    @GetMapping("/getAllEstatus")
    public ArrayList<EstatusAlmacenModel> getAllEstatusAlmacen(){
        return estatusAlmacenService.getAllEstatusAlmacen();
    }

    @PostMapping("/addEstatusAlmacen")
    public String addEstatusAlmacen(@RequestBody EstatusAlmacenModel estatusAlmacenModel){
        return estatusAlmacenService.addEstatusAlmacen(estatusAlmacenModel);
    }

    @PutMapping("/updateEstatusAlmacen/{id_estatus_almacen}")
    public String updateEstatusAlmacen(@RequestBody EstatusAlmacenModel estatusAlmacen, @PathVariable("id_estatus_almacen") Long id_estatus_almacen){
        return estatusAlmacenService.updateEstatusAlmacen(estatusAlmacen, id_estatus_almacen);
    }


}
