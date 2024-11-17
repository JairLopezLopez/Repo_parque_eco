package com.parqueeco.backendparqueeco.Rest;

import com.parqueeco.backendparqueeco.modelo.Imagenes;
import com.parqueeco.backendparqueeco.modelo.Paquetes;
import com.parqueeco.backendparqueeco.servicio.Imagenesservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping ("/imagenes")
public class ImagenesRest {

    @Autowired
    private Imagenesservice imagenesservice;

    @GetMapping
    private ResponseEntity<List<Imagenes>> getAllImagenes(){
        List<Imagenes> imagenes = imagenesservice.findAll();
        return ResponseEntity.ok(imagenes);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Imagenes> guardarImagen(
            @RequestBody Imagenes imagenes) {
        try {
            Imagenes imagenes1 = imagenesservice.guardarImagen(imagenes);
            return ResponseEntity.ok(imagenes1);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    
    @GetMapping("/imagenget/{id}")
    public ResponseEntity<byte[]> obtenerImagen(@PathVariable("id") Long imagenId) {
        Imagenes imagen = imagenesservice.getById(imagenId);

        if (imagen != null && imagen.getImagen() != null) {
            try {
                // Ruta de la imagen en el sistema de archivos
                String fileName = imagen.getImagen().substring(imagen.getImagen().lastIndexOf("/") + 1);
                Path path = Paths.get("uploads/images/" + fileName);

                // Lee los bytes de la imagen
                byte[] imageBytes = Files.readAllBytes(path);

                // Determina el tipo de contenido MIME
                String contentType = Files.probeContentType(path);
                if (contentType == null) {
                    contentType = "application/octet-stream";
                }

                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .body(imageBytes);
            } catch (IOException e) {
                e.printStackTrace();  // Log de la excepción
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarImagen(@PathVariable Long id) {
        try {
            imagenesservice.deleteById(id);
            return ResponseEntity.ok("Imagen eliminada con éxito");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Imagen no encontrada");
        }
    }

}
