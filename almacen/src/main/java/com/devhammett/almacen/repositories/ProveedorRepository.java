package com.devhammett.almacen.repositories;

import java.util.ArrayList;
import java.util.Optional;

import com.devhammett.almacen.models.ProveedorModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends CrudRepository <ProveedorModel,Long> {
    
    @Query("SELECT p FROM ProveedorModel p WHERE p.nombre_proveedor = ?1")
    Optional<ProveedorModel> findProveedorByNombre(String nombre_proveedor);

    @Query("SELECT p FROM ProveedorModel p WHERE p.id_estatus_proveedor = ?1")
    ArrayList<ProveedorModel> findProveedorByEstatus(Long id_estatus_proveedor);


}
