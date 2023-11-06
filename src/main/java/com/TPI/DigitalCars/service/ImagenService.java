package com.TPI.DigitalCars.service;

import com.TPI.DigitalCars.model.Imagen;
import com.TPI.DigitalCars.repository.ImagenRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ImagenService {
    @Autowired
    ImagenRepository imagenRepository;
    @Autowired
    ObjectMapper mapper;

    public ImagenService(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    public Imagen save(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    public List<Imagen> findAll() {
        return imagenRepository.findAll();
    }

    public Optional<Imagen> findById(Long id) {
        return imagenRepository.findById(id);
    }

    public void deleteById(Long id) {
        imagenRepository.deleteById(id);
    }
}
