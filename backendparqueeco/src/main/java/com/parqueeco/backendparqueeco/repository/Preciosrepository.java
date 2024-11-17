package com.parqueeco.backendparqueeco.repository;

import com.parqueeco.backendparqueeco.modelo.Precios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Preciosrepository extends JpaRepository<Precios,Long> {

}
