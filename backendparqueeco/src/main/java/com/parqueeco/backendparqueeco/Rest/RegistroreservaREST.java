package com.parqueeco.backendparqueeco.Rest;


import com.parqueeco.backendparqueeco.modelo.Paquetes;
import com.parqueeco.backendparqueeco.modelo.Registroreserva;
import com.parqueeco.backendparqueeco.modelo.Usuario;
import com.parqueeco.backendparqueeco.servicio.Registroreservaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping ("/registroreserva")
public class RegistroreservaREST {

    @Autowired
    private Registroreservaservice registroreservaservice;

    @GetMapping
    private ResponseEntity<List<Registroreserva>> getAllRegistroreserva(){
        List<Registroreserva> registroreservas = registroreservaservice.findAll();
        return ResponseEntity.ok(registroreservas);
    }

    @PostMapping ("/guardar")
    private ResponseEntity <Registroreserva> guardarRegistroreserva(
            @RequestParam long idreserva,
            @RequestParam long idprecio) {
        try {
            Registroreserva registroreserva = registroreservaservice.guardarregistroreservas(idreserva, idprecio);
            return ResponseEntity.ok(registroreserva);
        }catch (IOException e) {
            return  ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarRegistroreserva(@PathVariable Long id) {
        try {
            registroreservaservice.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado con éxito");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    @GetMapping("/registroget/{id}")
    public ResponseEntity<Registroreserva> obtenerUsuario(@PathVariable("id") Long registroreservaId) {
        Registroreserva registroreserva = registroreservaservice.getById(registroreservaId);
        if (registroreserva != null) {
            return ResponseEntity.ok(registroreserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
