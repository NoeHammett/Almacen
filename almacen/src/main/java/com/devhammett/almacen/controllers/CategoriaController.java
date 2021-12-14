package com.devhammett.almacen.controllers;

import java.util.ArrayList;

import com.devhammett.almacen.models.CategoriaModel;
import com.devhammett.almacen.services.CategoriaService;

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
@RequestMapping(path="api/categoria", produces = "application/json")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/getAllCategorias")
    public ArrayList<CategoriaModel> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @GetMapping("/getCategoria/{id_categoria}")
    public CategoriaModel getCategoria(@PathVariable("id_categoria") Long id_categoria) {
        return categoriaService.getCategoriaById(id_categoria);
    }

    @GetMapping("/getCategoriaByAnio/{anio_categoria}")
    public ArrayList<CategoriaModel> getCategoriaByAnio(@PathVariable("anio_categoria") Long anio_categoria){
        return categoriaService.getCategoriaByAnio(anio_categoria);
    }

    @PostMapping("/addCategoria")
    public CategoriaModel addCategoria(@RequestBody CategoriaModel categoriaModel) {
        return categoriaService.addCategoria(categoriaModel);
    }

    @PutMapping("/updateCategoria/{id_categoria}")
    public String updateCategoria(@RequestBody CategoriaModel categoriaModel,@PathVariable("id_categoria") Long id_categoria) {
        return  categoriaService.updateCategoria(categoriaModel,id_categoria);
    }

    @DeleteMapping("/deleteCategoria/{id_categoria}")
    public String dropCategoriaById (@PathVariable("id_categoria") Long id_categoria) {
        return categoriaService.dropCategoriaById(id_categoria);
    }

}
