package com.TPI.DigitalCars.controller;

import com.TPI.DigitalCars.model.Imagen;
import com.TPI.DigitalCars.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ImagenController {
    @Autowired
    ImagenService imagenService;

    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @GetMapping
    public List<Imagen> findAll() {
        return imagenService.findAll();
    }

    @PostMapping
    public Imagen save(@RequestBody Imagen imagen) {
        return imagenService.save(imagen);
    }

    @GetMapping("/{id}")
    public Optional<Imagen> findById(@PathVariable Long id) {
        return imagenService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        imagenService.deleteById(id);
    }
}
