package com.parqueeco.backendparqueeco.servicio;

import com.parqueeco.backendparqueeco.modelo.Paquetes;
import com.parqueeco.backendparqueeco.modelo.Precios;
import com.parqueeco.backendparqueeco.repository.Paquetesrepository;
import com.parqueeco.backendparqueeco.repository.Preciosrepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
//import org.springframework.util.Base64Utils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Service
public class Paquetesservice implements Paquetesrepository {


    @Autowired
    private  Paquetesrepository paquetesrepository;

    @Autowired
    private Preciosrepository preciosrepository;

    @Override
    public void flush() {

    }

    // Método para guardar una imagen en Base64 en la entidad Paquetes
    public Paquetes guardarImagenEnPaquete(Paquetes paquetes) throws IOException {

        // Leer la imagen desde el almacenamiento local
    //    File file = new File(paquetes.getImagen());
        // Leer los bytes del archivo
    //    byte[] fileContent = FileUtils.readFileToByteArray(file);

        // Convertir los bytes a una cadena en Base64
    //    String base64Image = Base64.getEncoder().encodeToString(fileContent);

        // Crear una nueva instancia de Paquetes
        Paquetes paquete = new Paquetes();
        paquete.setDescripcion(paquetes.getDescripcion());
        paquete.setTitulo(paquetes.getTitulo());
        paquete.setPrecio(paquetes.getPrecio());
        // Guardar la imagen codificada en base64 en la base de datos como una URL (luego se actualiza)
        //paquete.setImage(base64Image);

        //Convierte la base64 en imagen de vuelta
    //    byte[] decodedBytes = Base64.getDecoder().decode(base64Image);

    //    String fileName = UUID.randomUUID().toString() + ".jpg";  // Nombre único
    //    String folderPath = "uploads/images/";  // Carpeta donde se guardarán las imágenes
    //    File outputFile = new File(folderPath + fileName);

    //    if (!outputFile.getParentFile().exists()) {
    //        outputFile.getParentFile().mkdirs();
    //    }

        // Guardar la imagen decodificada en el disco local
    //    FileUtils.writeByteArrayToFile(outputFile, decodedBytes );

        // Guardar la URL de la imagen (ruta relativa a la carpeta del proyecto)
    //    String imageUrl = "/uploads/images/" + fileName;
    //    paquete.setImage(imageUrl);


       // if (paquetes.getPrecio() != null && paquetes.getPrecio().getId() != null) {
       //     Precios precio = preciosrepository.findById(paquetes.getId())
       //            .orElseThrow(() -> new IllegalArgumentException("Precio no encontrado"));
        //    paquetes.setPrecio(precio); // Asigna el precio al paquete
       // } else {
       //     throw new IllegalArgumentException("El precio es requerido");
       // }

        //System.out.println("Precio asignado: " + paquetes.getPrecio());

        // Guardar el paquete con la imagen en la base de datos
        return paquetesrepository.save(paquete);
    }

    public Paquetes actualizarPrecio(Long id, double nuevoPrecio) {
        Optional<Paquetes> paqueteOpt = paquetesrepository.findById(id);
        if (paqueteOpt.isPresent()) {
            Paquetes paquete = paqueteOpt.get();
            paquete.setPrecio(nuevoPrecio);  // Establece el nuevo precio
            return paquetesrepository.save(paquete);  // Guarda los cambios en la base de datos
        }
        return null;  // Si el paquete no existe, retorna null
    }

    public Paquetes actualizarActivo(Long id, boolean nuevoEstado) {
        Paquetes paquete = paquetesrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paquete no encontrado con id: " + id));

        // Cambiar el valor del booleano al contrario
        paquete.setActivo(!paquete.isActivo());

        return paquetesrepository.save(paquete);
    }

    @Override
    public <S extends Paquetes> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Paquetes> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Paquetes> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Paquetes getOne(Long aLong) {

        return null;
    }

    @Override
    public Paquetes getById(Long aLong) {

        return paquetesrepository.getById(aLong);
    }

    @Override
    public Paquetes getReferenceById(Long aLong) {

        return null;
    }

    @Override
    public <S extends Paquetes> Optional<S> findOne(Example<S> example) {

        return Optional.empty();
    }

    @Override
    public <S extends Paquetes> List<S> findAll(Example<S> example) {

        return List.of();
    }

    @Override
    public <S extends Paquetes> List<S> findAll(Example<S> example, Sort sort) {

        return List.of();
    }

    @Override
    public <S extends Paquetes> Page<S> findAll(Example<S> example, Pageable pageable) {

        return null;
    }

    @Override
    public <S extends Paquetes> long count(Example<S> example) {

        return 0;
    }

    @Override
    public <S extends Paquetes> boolean exists(Example<S> example) {

        return false;
    }

    @Override
    public <S extends Paquetes, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Paquetes> S save(S entity) {

        return paquetesrepository.save(entity);
    }

    @Override
    public <S extends Paquetes> List<S> saveAll(Iterable<S> entities) {

        return List.of();
    }

    @Override
    public Optional<Paquetes> findById(Long aLong) {

        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {

        return false;
    }

    @Override
    public List<Paquetes> findAll() {

        return paquetesrepository.findAll();
    }

    @Override
    public List<Paquetes> findAllById(Iterable<Long> longs) {

        return List.of();
    }

    @Override
    public long count() {

        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        paquetesrepository.deleteById(aLong);
    }

    @Override
    public void delete(Paquetes entity) {
        paquetesrepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Paquetes> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Paquetes> findAll(Sort sort) {

        return List.of();
    }

    @Override
    public Page<Paquetes> findAll(Pageable pageable) {

        return null;
    }
}
