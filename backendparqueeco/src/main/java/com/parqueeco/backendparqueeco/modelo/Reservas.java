package com.parqueeco.backendparqueeco.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
//import modelo.paquetes;
//import modelo.precios;
//import java.time.LocalDate;
//import java.time.LocalTime;

@Entity
@Data
@Table(name = "Reservas")
public class Reservas {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;


    @Column(name = "Hora")
    public String hora;


    @Column(name = "Fecha")
    public String fecha;

    @Column(name = "Numpersonas")
    public int numpersonas;

    @Column(name = "Numninos")
    public int numninos;

    @Column(name = "Pagoreserva")
    public double pagoreserva;

    @Column(name = "Nombre")
    public String nombre;

    @Column(name = "Apellido")
    public String apellido;

    @Column(name = "activo")
    private boolean activo = true;


    //Relaciones
    //@ManyToOne
    //@JoinColumn(name =  "id_precio")
    //private precios precio;
    //@ManyToOne
    //@JoinColumn(name =  "id_paquete")
    //private paquetes paquete;


    public Reservas() {

    }

    public Reservas(String hora, String fecha, int numpersonas, int numninos, double pagoreserva, String nombre, String apellido) {
        this.hora = hora;
        this.fecha = fecha;
        this.numpersonas = numpersonas;
        this.numninos = numninos;
        this.pagoreserva = pagoreserva;
        this.nombre = nombre;
        this.apellido = apellido;
        //this.precio = precio;
        //this.paquete = paquete;
    }
}
