package com.parqueeco.backendparqueeco.repository;


import com.parqueeco.backendparqueeco.modelo.Registroreserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registroreservarepository extends JpaRepository <Registroreserva,Long> {
}
