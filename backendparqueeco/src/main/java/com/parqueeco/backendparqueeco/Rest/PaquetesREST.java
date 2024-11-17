package com.parqueeco.backendparqueeco.Rest;

import com.parqueeco.backendparqueeco.modelo.Paquetes;
import com.parqueeco.backendparqueeco.modelo.Usuario;
import com.parqueeco.backendparqueeco.servicio.Paquetesservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/paquetes")
public class PaquetesREST {

    @Autowired
    private Paquetesservice paquetesservice;

    @GetMapping
    private ResponseEntity<List<Paquetes>> getAllPaquetes(){
        List<Paquetes> paquetes = paquetesservice.findAll();
        return ResponseEntity.ok(paquetes);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Paquetes> guardarPaquete(
            @RequestBody Paquetes paquetes) {
        try {
            Paquetes paquete = paquetesservice.guardarImagenEnPaquete(paquetes);
            return ResponseEntity.ok(paquete);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/usuarioget/{id}")
    public ResponseEntity<Paquetes> obtenerUsuario(@PathVariable("id") Long paqueteId) {
        Paquetes paquetes = paquetesservice.getById(paqueteId);
        if (paquetes != null) {
            return ResponseEntity.ok(paquetes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaquete(@PathVariable Long id) {
        try {
            paquetesservice.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado con éxito");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

     @PutMapping("/actualizarprecio/{id}")
    public ResponseEntity<Paquetes> actualizarPrecio(
            @PathVariable Long id, @RequestBody double nuevoPrecio) {
        try {
            Paquetes paqueteActualizado = paquetesservice.actualizarPrecio(id, nuevoPrecio);
            if (paqueteActualizado != null) {
                return ResponseEntity.ok(paqueteActualizado);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/actualizaractivo/{id}")
    public ResponseEntity<Paquetes> actualizarActivo(@PathVariable Long id, @RequestBody boolean nuevoEstado) {
        try {
            Paquetes paqueteActualizado = paquetesservice.actualizarActivo(id, nuevoEstado);
            if (paqueteActualizado != null) {
                return ResponseEntity.ok(paqueteActualizado);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
