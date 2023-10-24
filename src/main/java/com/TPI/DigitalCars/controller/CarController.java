package com.TPI.DigitalCars.controller;


import com.TPI.DigitalCars.exceptions.BadRequestException;
import com.TPI.DigitalCars.exceptions.ResourceNotFoundException;
import com.TPI.DigitalCars.model.Car;
import com.TPI.DigitalCars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.sql.Blob;
import javax.sql.rowset.serial.SerialBlob;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {


    private CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    //-------guardar auto-----

    @PostMapping
    public ResponseEntity<Car> guardarPaciente(@RequestBody Car car) {


        return ResponseEntity.ok(carService.guardarCar(car));
    }
    //---------------------------------GET LISTAR PACIENTE ----------------------------------------------
    @GetMapping("/listar")
    public ResponseEntity<List<Car>> listarCars() throws BadRequestException {
        List<Car> cars = carService.listarCars();
        if(cars.isEmpty()){
            //return ResponseEntity.badRequest().build();
            throw new BadRequestException("La lista se encuentra vacia");
        }else{
            return ResponseEntity.ok(cars);
        }
    }

}
