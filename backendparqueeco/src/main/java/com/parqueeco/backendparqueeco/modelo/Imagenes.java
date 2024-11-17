package com.parqueeco.backendparqueeco.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table (name = "imagenes")
public class Imagenes {

    @Setter
    @Getter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "descripcion")
    public String descripcion;

    @Getter
    @Setter
    @Column(name = "imagen")
    public String imagen;

    public Imagenes (){

    }

    public Imagenes(String descripcion, String image) {
        this.descripcion = descripcion;
        imagen = image;
    }
}
