package com.devhammett.almacen.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.devhammett.almacen.models.ArticuloModel;
import com.devhammett.almacen.repositories.ArticuloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloService {

    @Autowired
    ArticuloRepository articuloRepository;

    //Save Articulo
    public String addArticulo(ArticuloModel articulo){
        try {
            articuloRepository.save(articulo);
            return "Articulo guardado";
        } catch (Exception e) {
            return "Error al guardar Articulo \n" + e.getMessage();
        }
    }

    //Get All Articulos
    public ArrayList<ArticuloModel> getAllArticulos(){
        return (ArrayList<ArticuloModel>) articuloRepository.findAll();
    }

    //Get Articulos by Category
    public ArrayList<ArticuloModel> getArticulosByCategoria(Long id_categoria){
        return (ArrayList<ArticuloModel>) articuloRepository.findByCategoria(id_categoria);
    } 

    //Remove an Articulo
    public String removeArticulo(Long id_articulo){
        try{
            articuloRepository.deleteById(id_articulo);
            return "Articulo eliminado";
        } catch (Exception e) {
            return "Error al eliminar Articulo \n" + e.getMessage();
        }
    }
    //Update an Articulo
    @Transactional
    public String updateArticulo(ArticuloModel articulotoUpdate, Long id_articulo){
        ArticuloModel articulo = articuloRepository.findById(id_articulo).orElseThrow(() -> new IllegalArgumentException("No existe el Articulo con id: " + id_articulo));
        
        try{
            if(articulotoUpdate.getNombre_articulo() != null && articulotoUpdate.getNombre_articulo() != ""
             && articulotoUpdate.getDescripcion_articulo() !=null && articulotoUpdate.getDescripcion_articulo() != ""
             && articulotoUpdate.getPrecio() != null
             && articulotoUpdate.getCantidad_stock() !=null 
             && articulotoUpdate.getId_categoria() !=null && articulotoUpdate.getId_categoria() != 0){ 
                articulo.setNombre_articulo(articulotoUpdate.getNombre_articulo());
                articulo.setDescripcion_articulo(articulotoUpdate.getDescripcion_articulo());
                articulo.setPrecio(articulotoUpdate.getPrecio());
                articulo.setCantidad_stock(articulotoUpdate.getCantidad_stock());
                articulo.setId_categoria(articulotoUpdate.getId_categoria());
                return "Articulo actualizado";
                
            }else{
                return "Error al actualizar Articulo";
            }
        }catch(Exception e){
            return "Error al actualizar Articulo \n" + e.getMessage();
        }
    }



    
}
