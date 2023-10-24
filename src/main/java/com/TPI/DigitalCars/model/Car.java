package com.TPI.DigitalCars.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Blob;


import java.time.LocalDate;

@Getter
@Setter
@Entity
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

    @Column
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private Blob imagen;


    public Car(Long id, String marca, String modelo,int anioModelo, String patente, String motorCode, LocalDate fechaIngreso, Blob imagen) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anioModelo= anioModelo;
        this.patente = patente;
        this.motorCode = motorCode;
        this.fechaIngreso = fechaIngreso;
        this.imagen= imagen;
    }

    public Car(String marca, String modelo,int anioModelo, String patente, String motorCode, LocalDate fechaIngreso, Blob imagen) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioModelo= anioModelo;
        this.patente = patente;
        this.motorCode = motorCode;
        this.fechaIngreso = fechaIngreso;
        this.imagen= imagen;
    }


    public Car() {
    }

}
