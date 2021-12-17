package com.devhammett.almacen.repositories;

import java.util.ArrayList;
import java.util.Optional;

import com.devhammett.almacen.models.AlmacenModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenRepository extends CrudRepository<AlmacenModel, Long> {
    
    @Query("SELECT a from AlmacenModel a WHERE a.id_estatus_almacen=?1")
    public ArrayList<AlmacenModel> fyndByEstatus(Long id_estatus_almacen);

    @Query("Select a from AlmacenModel a WHERE a.email_almacen =?1")
    Optional<AlmacenModel> fyndByEmail(String email_almacen);


}
