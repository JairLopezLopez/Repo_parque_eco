package com.parqueeco.backendparqueeco.servicio;

import com.parqueeco.backendparqueeco.modelo.Imagenes;
import com.parqueeco.backendparqueeco.modelo.Paquetes;
import com.parqueeco.backendparqueeco.modelo.Precios;
import com.parqueeco.backendparqueeco.repository.Imagenesrepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Service
public class Imagenesservice implements  Imagenesrepository{

    @Autowired
    private Imagenesrepository imagenesrepository;


    public Imagenes guardarImagen(Imagenes imagenes) throws IOException {

        // Leer la imagen desde el almacenamiento local
        File file = new File(imagenes.getImagen());
        // Leer los bytes del archivo
        byte[] fileContent = FileUtils.readFileToByteArray(file);

        // Convertir los bytes a una cadena en Base64
        String base64Image = Base64.getEncoder().encodeToString(fileContent);

        // Crear una nueva instancia de Paquetes
        Imagenes imagenesp = new Imagenes();
        imagenesp.setDescripcion(imagenes.getDescripcion());
        // Guardar la imagen codificada en base64 en la base de datos como una URL (luego se actualiza)
        //paquete.setImage(base64Image);

        //Convierte la base64 en imagen de vuelta
        byte[] decodedBytes = Base64.getDecoder().decode(base64Image);

        String fileName = UUID.randomUUID().toString() + ".jpg";  // Nombre único
        String folderPath = "uploads/images/";  // Carpeta donde se guardarán las imágenes
        File outputFile = new File(folderPath + fileName);

        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }

        // Guardar la imagen decodificada en el disco local
        FileUtils.writeByteArrayToFile(outputFile, decodedBytes );

        // Guardar la URL de la imagen (ruta relativa a la carpeta del proyecto)
        String imageUrl = "/uploads/images/" + fileName;
        imagenesp.setImagen(imageUrl);


        // Guardar el paquete con la imagen en la base de datos
        return imagenesrepository.save(imagenesp);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Imagenes> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Imagenes> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Imagenes> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Imagenes getOne(Long aLong) {
        return null;
    }

    @Override
    public Imagenes getById(Long aLong) {

        return imagenesrepository.getById(aLong);
    }

    @Override
    public Imagenes getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Imagenes> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Imagenes> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Imagenes> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Imagenes> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Imagenes> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Imagenes> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Imagenes, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Imagenes> S save(S entity) {
        return imagenesrepository.save(entity);
    }

    @Override
    public <S extends Imagenes> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Imagenes> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Imagenes> findAll() {
        return imagenesrepository.findAll();
    }

    @Override
    public List<Imagenes> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        imagenesrepository.deleteById(aLong);
    }

    @Override
    public void delete(Imagenes entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Imagenes> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Imagenes> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Imagenes> findAll(Pageable pageable) {
        return null;
    }
}
