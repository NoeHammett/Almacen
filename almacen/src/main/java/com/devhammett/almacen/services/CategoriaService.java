package com.devhammett.almacen.services;

import java.util.ArrayList;
import javax.transaction.Transactional;

import com.devhammett.almacen.models.CategoriaModel;
import com.devhammett.almacen.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    // Save Categoria
    public CategoriaModel addCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    // Get All Categorias
    public ArrayList<CategoriaModel> getAllCategorias() {
        return (ArrayList<CategoriaModel>) categoriaRepository.findAll();
    }

    // Get Categoria by ID
    public CategoriaModel getCategoriaById(Long id_categoria) {
        return categoriaRepository.findById(id_categoria).get();
    }

    //Get Categoriaby Anio
    public ArrayList<CategoriaModel> getCategoriaByAnio(Long anio_categoria){
            return categoriaRepository.findbyAnio(anio_categoria);
    }    

    // Remove one element
    public String dropCategoriaById(Long id) {
        try {
            categoriaRepository.deleteById(id);
            return "Categoria eliminada";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    // Update Categoria
    @Transactional
    public String updateCategoria(CategoriaModel categoriaModelR, Long id_categoria) {
        CategoriaModel categoria = categoriaRepository.findById(id_categoria)
                .orElseThrow(() -> new IllegalStateException("La categoria no existe"));
        try{
            if (categoriaModelR.getNombre_categoria() != null && categoriaModelR.getNombre_categoria().length() > 0 && !categoriaModelR.getNombre_categoria().equals("") &&
            categoriaModelR.getDescripcion_categoria() != null && categoriaModelR.getDescripcion_categoria().length() > 0 && !categoriaModelR.getDescripcion_categoria().equals("") &&
            categoriaModelR.getAnio_categoria() != null && categoriaModelR.getAnio_categoria() > 0) {
                categoria.setNombre_categoria(categoriaModelR.getNombre_categoria());
                categoria.setDescripcion_categoria(categoriaModelR.getDescripcion_categoria());
                categoria.setAnio_categoria(categoriaModelR.getAnio_categoria());
                return "Categoria actualizada";
            }else{
                return "No se pudo actualizar la categoria";
            }
        }catch(Exception e){
            return "Error al actualizar la categoria \n" + e.getMessage();
        }
        

    }

}
