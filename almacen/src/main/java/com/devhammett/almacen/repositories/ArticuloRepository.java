package com.devhammett.almacen.repositories;

import java.util.ArrayList;

import com.devhammett.almacen.models.ArticuloModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends CrudRepository<ArticuloModel, Long> {

    @Query("SELECT a FROM ArticuloModel a WHERE a.id_categoria =?1")
    ArrayList<ArticuloModel> findByCategoria(Long id_categoria);

}
