package com.devhammett.almacen.repositories;

import com.devhammett.almacen.models.EstatusUsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstatusUsuarioRepository  extends CrudRepository<EstatusUsuarioModel,Long>{
    
}
