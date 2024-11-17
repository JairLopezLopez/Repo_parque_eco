package com.parqueeco.backendparqueeco.repository;

import com.parqueeco.backendparqueeco.modelo.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Imagenesrepository extends JpaRepository <Imagenes, Long> {
}
