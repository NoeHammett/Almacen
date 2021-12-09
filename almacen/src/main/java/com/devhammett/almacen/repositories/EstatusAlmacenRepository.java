package com.devhammett.almacen.repositories;

import com.devhammett.almacen.models.EstatusAlmacenModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstatusAlmacenRepository extends CrudRepository<EstatusAlmacenModel,Long> {
    
}
