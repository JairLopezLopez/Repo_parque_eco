package com.parqueeco.backendparqueeco.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "Registroreservas")
public class Registroreserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "Id")
    private Long id;
    @Column (name = "idreserva")
    private Long idreserva;
    @Column(name = "idprecio")
    private Long idprecio;

    public Registroreserva() {

    }

    public Registroreserva(Long idreserva, Long idprecio) {
        this.idreserva = idreserva;
        this.idprecio = idprecio;
    }

}
