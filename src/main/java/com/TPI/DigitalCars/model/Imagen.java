package com.TPI.DigitalCars.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    // Agregar una referencia a la entidad Car a la que pertenece la imagen
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}
