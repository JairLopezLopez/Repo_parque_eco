package com.parqueeco.backendparqueeco.Rest;


import com.parqueeco.backendparqueeco.modelo.Paquetes;
import com.parqueeco.backendparqueeco.modelo.Precios;
import com.parqueeco.backendparqueeco.modelo.Registroreserva;
import com.parqueeco.backendparqueeco.servicio.Preciosservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping ("/precios")
public class PreciosREST {

    @Autowired
    private Preciosservice preciosservice;

    @GetMapping
    private ResponseEntity<List<Precios>> getAllPrecios(){
        List<Precios> precios = preciosservice.findAll();
        return ResponseEntity.ok(precios);
    }

    @PostMapping("/guardar")
    private  ResponseEntity <Precios> guardaPrecio (
            @RequestParam double precio,
            @RequestParam boolean activo){
        try {
            Precios precios = preciosservice.guardarPrecios(precio, activo);
            return ResponseEntity.ok(precios);
        } catch (IOException e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPrecio(@PathVariable Long id) {
        try {
            preciosservice.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado con éxito");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    @GetMapping("/registroget/{id}")
    public ResponseEntity<Precios> obtenerUsuario(@PathVariable("id") Long precioId) {
        Precios precios = preciosservice.getById(precioId);
        if (precios!= null) {
            return ResponseEntity.ok(precios);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
