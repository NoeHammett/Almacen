package com.devhammett.almacen.repositories;

import java.util.ArrayList;
import java.util.Optional;

import com.devhammett.almacen.models.UsuarioModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long>{
    
    @Query("SELECT u FROM UsuarioModel u WHERE u.email_usuario = ?1")
    Optional<UsuarioModel> findUsuarioByEmail(String email_usuario);

    @Query("SELECT u FROM UsuarioModel u WHERE u.nickname_usuario = ?1")
    Optional<UsuarioModel> findUsuarioByNickname(String nickname_usuario);

    @Query("SELECT u FROM UsuarioModel u WHERE u.id_estatus_usuario =?1")
    ArrayList<UsuarioModel> findUsuarioByIdEstatus (Long id_estatus_usuario);
}
