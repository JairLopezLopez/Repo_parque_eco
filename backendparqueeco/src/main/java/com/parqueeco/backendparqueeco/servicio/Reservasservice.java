package com.parqueeco.backendparqueeco.servicio;

import com.parqueeco.backendparqueeco.modelo.Reservas;
import com.parqueeco.backendparqueeco.repository.Reservasrepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
public class Reservasservice implements Reservasrepository {

    @Autowired
    private Reservasrepository resevasrepository;

    @Transactional
    public Reservas guardarReservas (String horapath, String fechapath, int numpersonaspath, int numninos, double pagoreservapath, String nombrepat, String apellidopat) throws IOException {

        Reservas reservas = new Reservas();
        reservas.setHora(horapath);
        reservas.setFecha(fechapath);
        reservas.setNumpersonas(numpersonaspath);
        reservas.setNumninos(numninos);
        reservas.setPagoreserva(pagoreservapath);
        reservas.setNombre(nombrepat);
        reservas.setApellido(apellidopat);

        return  resevasrepository.save(reservas);
    }

    public Reservas actualizaractivo(Long id) {
        Reservas reservas = resevasrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con id: " + id));

        // Alterna el valor de `activo`
        reservas.setActivo(!reservas.isActivo());

        return resevasrepository.save(reservas);
    }


    @Override
    public void flush() {

    }

    @Override
    public <S extends Reservas> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Reservas> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Reservas> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Reservas getOne(Long aLong) {
        return null;
    }

    @Override
    public Reservas getById(Long aLong) {
        return null;
    }

    @Override
    public Reservas getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Reservas> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Reservas> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Reservas> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Reservas> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Reservas> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Reservas> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Reservas, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Reservas> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Reservas> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Reservas> findById(Long aLong) {
        return resevasrepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Reservas> findAll() {
        return resevasrepository.findAll();
    }

    @Override
    public List<Reservas> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        resevasrepository.deleteById(aLong);
    }

    @Override
    public void delete(Reservas entity) {
        resevasrepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Reservas> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Reservas> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Reservas> findAll(Pageable pageable) {
        return null;
    }
}
