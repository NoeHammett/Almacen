package com.devhammett.almacen.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.devhammett.almacen.models.UsuarioModel;
import com.devhammett.almacen.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/usuario", produces="application/json")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/addUsuario")
    public String addUsuario(@RequestBody UsuarioModel usuario){
        return usuarioService.addUsuario(usuario);
    }

    @GetMapping("/getUsuarioById/{id_usuario}")
    public UsuarioModel getUsuarioById(@PathVariable Long id_usuario){
        return usuarioService.getUsuarioById(id_usuario);
    }

    @GetMapping("/getUsuarioByEstatus/{id_estatus_usuario}")
    public ArrayList<UsuarioModel> getUsuarioByEstatus(@PathVariable("id_estatus_usuario") Long id_estatus_usuario){
        return usuarioService.getUsuarioEstatus(id_estatus_usuario);   
    }

    @GetMapping("/getUsuarioByEmail/{email_usuario}")
    public Optional<UsuarioModel> getUsuarioByEmail(@PathVariable("email_usuario") String email_usuario){
        return usuarioService.getUsuarioByEmail(email_usuario);
    }

    @PutMapping("/updateUsuario/{id_usuario}")
    public String updateUsuario(@RequestBody UsuarioModel usuario,@PathVariable Long id_usuario){
        return usuarioService.updateUsuario(usuario, id_usuario);
    }
}
