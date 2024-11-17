package com.parqueeco.backendparqueeco.repository;

import com.parqueeco.backendparqueeco.modelo.Paquetes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Paquetesrepository extends JpaRepository<Paquetes, Long> {


}


