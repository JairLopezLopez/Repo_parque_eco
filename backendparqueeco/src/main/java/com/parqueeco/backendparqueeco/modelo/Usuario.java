package com.parqueeco.backendparqueeco.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;


@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    @Getter
    @Setter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name = "apellido")
    private String apellido;

    @Getter
    @Setter
    @Column(name = "password")
    private String password;


    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }


}