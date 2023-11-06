package com.TPI.DigitalCars.service;


import com.TPI.DigitalCars.dto.CarDTO;
import com.TPI.DigitalCars.dto.CategoryDTO;
import com.TPI.DigitalCars.exceptions.BadRequestException;
import com.TPI.DigitalCars.exceptions.ResourceNotFoundException;
import com.TPI.DigitalCars.model.Car;
import com.TPI.DigitalCars.model.Category;
import com.TPI.DigitalCars.model.Imagen;
import com.TPI.DigitalCars.repository.CarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository CarRepository;
    @Autowired
    ObjectMapper mapper;
    public List<Car> listarCars(){
        return CarRepository.findAll();
    }

    public Optional<Car> buscarCar(Long id){
        Optional<Car> car = CarRepository.findById(id);
        return CarRepository.findById(id);
    }


    public Car guardarCar(CarDTO carDTO){

        Car car = mapper.convertValue(carDTO,Car.class);

        System.out.println(car);
        car.setFechaIngreso(LocalDate.now());
        return CarRepository.save(car);
    }


    public Car actualizarCar (Car car)throws BadRequestException {

        if (buscarCar(car.getId()).isPresent()){
            return (Car) CarRepository.save(car);
        }else{
            throw new BadRequestException("No se encontro el auto, no fue actualizado");
        }

    }



    public void eliminarCar(Long id) throws ResourceNotFoundException {
        Optional<Car> car = buscarCar(id);
        if(car.isPresent()){
            CarRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No existe el auto con el id " + id + ", no se pudo eliminar.");
        }

    }

    public Optional<Car> buscarPorPatente(String patente) throws ResourceNotFoundException {
        Optional<Car> car = CarRepository.findByPatente(patente);
        if (car.isPresent()){
            return car;
        }else {
            throw new ResourceNotFoundException("No se encontro el auto con patente: " + patente );
        }
    }

}
