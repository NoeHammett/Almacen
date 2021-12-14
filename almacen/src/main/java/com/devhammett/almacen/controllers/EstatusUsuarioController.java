package com.devhammett.almacen.controllers;

import java.util.ArrayList;

import com.devhammett.almacen.models.EstatusUsuarioModel;
import com.devhammett.almacen.services.EstatusUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/estatusUsuario", produces = "application/json")
public class EstatusUsuarioController {
    
    @Autowired
    EstatusUsuarioService estatusUsuarioService;

    @GetMapping("/getAllEstatusUsuario")
    public ArrayList<EstatusUsuarioModel> getAllEstatusUsuario(){
        return estatusUsuarioService.getAllEstatusUsuario();
    }

    @PostMapping("/addEstatusUsuario")
    public String addEstatusUsuario(@RequestBody EstatusUsuarioModel estatusUsuarioModel) {
        return estatusUsuarioService.addEstatusUsuario(estatusUsuarioModel);
    }

    @PutMapping("/updateEstatusUsuario/{id_estatus_usuario}")
    public String updateEstatusUsuario (@RequestBody EstatusUsuarioModel estatusUsuario,@PathVariable("id_estatus_usuario") Long id_estatus_usuario){
        return estatusUsuarioService.updateEstatusUsuario(estatusUsuario, id_estatus_usuario);
    }
}
