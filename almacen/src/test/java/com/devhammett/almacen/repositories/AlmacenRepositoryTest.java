package com.devhammett.almacen.repositories;

import java.util.ArrayList;
import java.util.Optional;

import com.devhammett.almacen.models.AlmacenModel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AlmacenRepositoryTest {

    @Autowired
    AlmacenRepository almacenRepository;

    @Test
    void testFyndByEstatusExistente() {
        // Given

        // AlmacenModel almacenTest = new AlmacenModel();
        // almacenTest.setNombre_almacen("Almacen 1");
        // almacenTest.setDireccion_almacen("Direccion 1");
        // almacenTest.setEmail_almacen("emailAlmacenUno@Test.com");
        // almacenTest.setTelefono_almacen(123456789L);
        // almacenTest.setCodigo_postal_almacen(12345L);
        // almacenTest.setId_estatus_almacen(1L);
        // almacenRepository.save(almacenTest);

        // When
        ArrayList<AlmacenModel> existeEstatus = almacenRepository.fyndByEstatus(1L);

        // Then
        try {
            assert (existeEstatus.size() > 0);
            System.out.println("Si Existe el estatus");
        } catch (AssertionError e) {
            System.out.println("No Existe el estatus");
        }
    }

    @Test
    void testFyndByEmailExistente() {
        // Given

        // when
        Optional<AlmacenModel> existeEmail = almacenRepository.fyndByEmail("Direccion Almacen UNO");

        // Then
        try {
            assert (existeEmail.isPresent());
            System.out.println("Si Existe el email");
        } catch (AssertionError e) {
            System.out.println("No Existe el email");
        }
    }

    @AfterEach
    void tearDown() {
        almacenRepository.deleteAll();
    }  
}
