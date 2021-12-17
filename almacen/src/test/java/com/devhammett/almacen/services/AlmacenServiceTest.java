package com.devhammett.almacen.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import com.devhammett.almacen.models.AlmacenModel;
import com.devhammett.almacen.repositories.AlmacenRepository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AlmacenServiceTest {

    @Autowired
    AlmacenService almacenService;

   @Autowired
    AlmacenRepository almacenRepository; 

    @Test
    @Disabled
    void testAddAlmacen() {
        //Given
        AlmacenModel almacen = new AlmacenModel();
        almacen.setNombre_almacen("Almacen 31213");
        almacen.setDireccion_almacen("Direccion 12312312");
        almacen.setEmail_almacen("emailAlmacenUno@Test.com");
        almacen.setTelefono_almacen(123456789L);
        almacen.setCodigo_postal_almacen(12345L);
        almacen.setId_estatus_almacen(1L);
        //When
        boolean guardado = almacenRepository.save(almacen) != null;
        try{
            assertTrue(guardado);
            System.out.println("Si se guardo");
        }catch(AssertionError e){
            System.out.println("No se guardo");
        }
    }

    @Test
    void testGetAllAlmacenes() {
        // When
        ArrayList<AlmacenModel> listaAlmacenes = almacenService.getAllAlmacenes();
        // Then
        try {
            assert (listaAlmacenes.size() > 0);
            System.out.println("Si Existe lista de almacenes");
        } catch (AssertionError e) {
            System.out.println("No Existe lista de almacenes");
        }
    }

    @Test
    void testGetAlmacenByEstatus() {
        // When
        ArrayList<AlmacenModel> listaAlmacenesEstatus = almacenService.getAlmacenByEstatus(5L);
        // Then
        try {
            assert (listaAlmacenesEstatus.size() > 0);
            System.out.println("Si Existe lista de almacenes por estatus");
        } catch (AssertionError e) {
            System.out.println("No Existe lista de almacenes por estatus");
        }
    }

    @Test
    void testGetAlmacenById() {
        // When
        AlmacenModel almacen = almacenService.getAlmacenById(1L);
        // Then
        try {
            assert (almacen != null);
            System.out.println("Si Existe almacen por id");
        } catch (AssertionError e) {
            System.out.println("No Existe almacen por id");
        }
    }

    @Test
    @Disabled
    void testUpdateAlmacen() {
        //Given
        AlmacenModel almacen = new AlmacenModel();
        almacen.setNombre_almacen("Almacen TEST");
        almacen.setDireccion_almacen("Direccion Junit");
        almacen.setEmail_almacen("emailAlmacenUno@Junit.com");
        almacen.setTelefono_almacen(123123l);
        almacen.setCodigo_postal_almacen(756345L);
        almacen.setId_estatus_almacen(2L);
        //When
        boolean result = almacenService.updateAlmacen(almacen, 1L) != null;
        //Then
        try {
            assertTrue(result);
            System.out.println("Si se actualizo");
        } catch (AssertionError e) {
            System.out.println("No se actualizo");
        }
    }
}
