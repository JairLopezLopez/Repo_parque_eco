package com.parqueeco.backendparqueeco.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Table(name = "paquetes")
public class Paquetes {

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
    @Column(name = "titulo")
    public String titulo;

    @Getter
    @Setter
    @Column(name = "precio")
    public double precio;

    @Column(name = "activo")
    private boolean activo = true;

    //@Column(name = "imagen")
    //public String imagen;

    //Relaciones
    //@ManyToOne
   //@JoinColumn(name = "precio_id")
   // private Precios precio;

    public Paquetes() {

    }

    public Paquetes(String descripcion, String image) {
        this.descripcion = descripcion;
        //imagen = image;
        this.precio = precio;
        this.titulo = titulo;


    }

    //public String getImage() {
    //    return imagen;
    //}

    //public void setImage(String image) {
    //    imagen = image;
    //}

    //public Precios getPrecio() {
        //return precio;
    //}

    //public void setPrecio(Precios precio) {
      //  this.precio = precio;
    //}
}
