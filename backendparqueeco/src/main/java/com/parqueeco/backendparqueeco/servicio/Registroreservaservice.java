package com.parqueeco.backendparqueeco.servicio;


import com.parqueeco.backendparqueeco.modelo.Registroreserva;
import com.parqueeco.backendparqueeco.repository.Registroreservarepository;
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
public class Registroreservaservice implements  Registroreservarepository{

    @Autowired
    private Registroreservarepository registroreservarepository;

    public  Registroreserva guardarregistroreservas (long idreservapath, long idpreciopath) throws IOException {
        Registroreserva registroreserva = new Registroreserva();
        registroreserva.setIdprecio(idpreciopath);
        registroreserva.setIdreserva(idreservapath);

        return  registroreservarepository.save(registroreserva);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Registroreserva> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Registroreserva> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Registroreserva> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Registroreserva getOne(Long aLong) {
        return null;
    }

    @Override
    public Registroreserva getById(Long aLong) {
        return null;
    }

    @Override
    public Registroreserva getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Registroreserva> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Registroreserva> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Registroreserva> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Registroreserva> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Registroreserva> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Registroreserva> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Registroreserva, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Registroreserva> S save(S entity) {
        return registroreservarepository.save(entity);
    }

    @Override
    public <S extends Registroreserva> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Registroreserva> findById(Long aLong) {
        return registroreservarepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Registroreserva> findAll() {
        return registroreservarepository.findAll();
    }

    @Override
    public List<Registroreserva> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

        registroreservarepository.deleteById(aLong);
    }

    @Override
    public void delete(Registroreserva entity) {
        registroreservarepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Registroreserva> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Registroreserva> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Registroreserva> findAll(Pageable pageable) {
        return null;
    }
}
