package com.devhammett.almacen.repositories;

import java.util.ArrayList;

import com.devhammett.almacen.models.AlmacenModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenRepository extends CrudRepository<AlmacenModel, Long> {
    
    @Query("SELECT a from AlmacenModel a where a.id_estatus_almacen=?1")
    public ArrayList<AlmacenModel> fyndByEstatus(Long id_estatus_almacen);

}
