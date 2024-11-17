package com.parqueeco.backendparqueeco.servicio;


import com.parqueeco.backendparqueeco.modelo.Usuario;
import com.parqueeco.backendparqueeco.repository.Usuariorepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
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
public class Usuarioservice implements Usuariorepository{

    @Autowired
    private Usuariorepository usuariorepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Usuario guardarUsuario (String nombrepath, String apellidopath, String passwordpath) throws IOException{

        Usuario usuario = new Usuario();
        usuario.setNombre(nombrepath);
        usuario.setApellido(apellidopath);

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash( 1 , 1024, 2, passwordpath);
        usuario.setPassword(hash);

        return usuariorepository.save(usuario);
    }


    public  boolean verificarusuario (Usuario usuario){
        String query = "FROM Usuario WHERE nombre = :nombre";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("nombre", usuario.getNombre())
                .getResultList();

        if (lista.isEmpty()){
            return  false;
        }

        String passwordhasheada = lista.get(0).getPassword();

        Argon2 argon3 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon3.verify(passwordhasheada, usuario.getPassword());

    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Optional<Usuario> usuarioExistente = usuariorepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();

            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellido(usuarioActualizado.getApellido());

            // Comprobar si se proporciona una nueva contraseña y hashearla
            if (usuarioActualizado.getPassword() != null && !usuarioActualizado.getPassword().isEmpty()) {
                Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
                String hashedPassword = argon2.hash(1, 1024, 2, usuarioActualizado.getPassword());
                usuario.setPassword(hashedPassword); // Guardar la contraseña hasheada
            }

            return usuariorepository.save(usuario);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Usuario> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Usuario> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Usuario> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Usuario getOne(Long aLong) {
        return null;
    }

    @Override
    public Usuario getById(Long aLong) {

        return usuariorepository.getById(aLong);
    }

    @Override
    public Usuario getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Usuario> Optional<S> findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Usuario> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Usuario> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Usuario> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Usuario> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Usuario> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Usuario, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Usuario> S save(S entity) {

        return null;
    }

    @Override
    public <S extends Usuario> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Usuario> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Usuario> findAll() {
        return usuariorepository.findAll();
    }

    @Override
    public List<Usuario> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

        usuariorepository.deleteById(aLong);

    }

    @Override
    public void delete(Usuario entity) {

        usuariorepository.delete(entity);

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Usuario> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Usuario> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return null;
    }
}
