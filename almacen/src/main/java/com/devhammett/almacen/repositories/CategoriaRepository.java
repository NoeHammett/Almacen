package com.devhammett.almacen.repositories;
import java.util.ArrayList;
import com.devhammett.almacen.models.CategoriaModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends CrudRepository<CategoriaModel, Long> {

    //SQL Native
    //JQL | JPQL
    //QueryMethod

    @Query("SELECT c FROM CategoriaModel c Where c.anio_categoria = ?1")
    ArrayList<CategoriaModel> findbyAnio(Long anio_categoria);

}
    
