package com.parqueeco.backendparqueeco.Rest;

import com.parqueeco.backendparqueeco.modelo.Reservas;
import com.parqueeco.backendparqueeco.modelo.Usuario;
import com.parqueeco.backendparqueeco.repository.Reservasrepository;
import com.parqueeco.backendparqueeco.servicio.Registroreservaservice;
import com.parqueeco.backendparqueeco.servicio.Reservasservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import servicio.reservasservice;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservasREST {

    @Autowired
    private Reservasservice reservasservice;

    @GetMapping
    private ResponseEntity<List<Reservas>> getAllReservas(){
        List<Reservas> reservas = reservasservice.findAll();
        return ResponseEntity.ok(reservas);
    }


    @PostMapping("/guardar")
    private ResponseEntity <Reservas> guardarReserva(
            @RequestBody Reservas reservas) {
        try {
            Reservas reservasg = reservasservice.guardarReservas(reservas.getHora(), reservas.getFecha(),
                    reservas.getNumpersonas(), reservas.getNumninos(), reservas.getPagoreserva(),
                    reservas.getNombre(), reservas.getApellido());
            return ResponseEntity.ok(reservas);
        } catch (IOException e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping ("/eliminar/{id}")
    public ResponseEntity<String> eliminareserva(@PathVariable Long id) {
        try {
            reservasservice.deleteById(id);
            return ResponseEntity.ok("Reserva eliminada con éxito");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva no encontrada");
        }
    }

    @GetMapping("/reservasget/{id}")
    public ResponseEntity<Reservas> obtenerreserva(@PathVariable("id") Long reservaId) {
        Reservas reservas = reservasservice.getById(reservaId);
        if (reservas != null) {
            return ResponseEntity.ok(reservas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizaractivo/{id}")
    public ResponseEntity<Reservas> actualizaractivo(
            @PathVariable Long id) {
        try {
            Reservas reservasactualizado = reservasservice.actualizaractivo(id);
            return ResponseEntity.ok(reservasactualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }


}
