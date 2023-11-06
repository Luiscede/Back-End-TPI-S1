package com.TPI.DigitalCars.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.sql.Blob;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")

public class Car {

    @Id
    @SequenceGenerator(name = "car_sequence", sequenceName = "car_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_sequence")
    private Long id;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private int anioModelo;

    @Column
    private String patente;
    @Column
    private String motorCode;

    @Column
    private LocalDate fechaIngreso;

    /*
    @Column
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private Blob imagen;

     */

    // Agregar la propiedad imagenes como una lista de imagen
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imagen> imagenes;

    private List<String> categories;


}
