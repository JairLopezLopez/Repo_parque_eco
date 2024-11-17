package com.parqueeco.backendparqueeco.repository;

import com.parqueeco.backendparqueeco.modelo.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reservasrepository extends JpaRepository <Reservas,Long> {
}
