package com.parqueeco.backendparqueeco.servicio;

import com.parqueeco.backendparqueeco.modelo.Precios;
import com.parqueeco.backendparqueeco.repository.Preciosrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class Preciosservice implements Preciosrepository{

    @Autowired
    private Preciosrepository preciosrepository;


    public Precios guardarPrecios (double preciopath, boolean activopath) throws IOException {

        Precios precios = new Precios();
        precios.setPrecio(preciopath);
        precios.setActivo(activopath);

        return preciosrepository.save(precios);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Precios> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Precios> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Precios> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Precios getOne(Long aLong) {

        return null;
    }

    @Override
    public Precios getById(Long aLong) {

        return preciosrepository.getById(aLong);
    }

    @Override
    public Precios getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Precios> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Precios> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Precios> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Precios> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Precios> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Precios> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Precios, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Precios> S save(S entity) {

        return preciosrepository.save(entity);
    }

    @Override
    public <S extends Precios> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Precios> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Precios> findAll() {
        return preciosrepository.findAll();
    }

    @Override
    public List<Precios> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

        preciosrepository.deleteById(aLong);
    }

    @Override
    public void delete(Precios entity) {

        preciosrepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Precios> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Precios> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Precios> findAll(Pageable pageable) {
        return null;
    }
}
