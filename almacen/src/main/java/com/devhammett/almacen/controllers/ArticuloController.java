package com.devhammett.almacen.controllers;


import java.util.ArrayList;

import com.devhammett.almacen.models.ArticuloModel;
import com.devhammett.almacen.services.ArticuloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/articulo", produces = "application/json")
public class ArticuloController {
    
    @Autowired
    ArticuloService articuloService;

    @GetMapping("/getAllArticulos")
    public ArrayList<ArticuloModel> getAllArticulos(){
        return articuloService.getAllArticulos();
    }

    @GetMapping("/getArticuloByCategoria/{id_categoria}")
    public ArrayList<ArticuloModel>getArticulosByCategoria(@PathVariable("id_categoria") Long id_categoria){
        return articuloService.getArticulosByCategoria(id_categoria);
    }

    @PostMapping("/addArticulo")
    public String addArticulo(@RequestBody ArticuloModel articuloModel){
        return articuloService.addArticulo(articuloModel);
    }

    @PutMapping("/updateArticulo/{id_articulo}")
    public String updateArticulo(@RequestBody ArticuloModel articuloModel,@PathVariable("id_articulo") Long id_articulo){
        return articuloService.updateArticulo(articuloModel, id_articulo);
    }

    @DeleteMapping("/deleteArticulo/{id_articulo}")
    public String deleteArticulo(@PathVariable("id_articulo") Long id_articulo){
        return articuloService.removeArticulo(id_articulo);
    }
}
