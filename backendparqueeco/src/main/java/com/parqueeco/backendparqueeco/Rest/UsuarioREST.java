package com.parqueeco.backendparqueeco.Rest;


//import com.parqueeco.backendparqueeco.modelo.Reservas;
import com.parqueeco.backendparqueeco.modelo.Usuario;
import com.parqueeco.backendparqueeco.servicio.Usuarioservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioREST {

    @Autowired
    private Usuarioservice usuarioservice;

    @GetMapping
    private ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> usuarios = usuarioservice.findAll();
        return ResponseEntity.ok(usuarios);
    }


    @PostMapping ("/guardar")
    public ResponseEntity <Usuario> guardarUsuario(
            @RequestBody Usuario usuario) {
        try {
            Usuario usuariod = usuarioservice.guardarUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getPassword());
            return ResponseEntity.ok(usuario);
        } catch (IOException e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping ("/iniciosesion")
    public ResponseEntity<Map<String, String>> login(@RequestBody Usuario usuario) {
        boolean esValido = usuarioservice.verificarusuario(usuario);

        Map<String, String> response = new HashMap<>();
        if (esValido) {
            response.put("message", "Login exitoso");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Credenciales inválidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        try {
            usuarioservice.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado con éxito");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    @GetMapping("/usuarioget/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") Long usuarioId) {
        Usuario usuario = usuarioservice.getById(usuarioId);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/modificarusuario/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuarioActualizado) {
        try {
            Usuario usuario = usuarioservice.actualizarUsuario(id, usuarioActualizado);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

