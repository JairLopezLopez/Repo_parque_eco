package com.parqueeco.backendparqueeco.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "precios")
public class Precios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "precio")
    public double precio;
    @Column(name = "activo")
    private boolean activo;


    public Precios() {

    }

    public Precios(double precio, boolean activo) {
        this.precio = precio;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
