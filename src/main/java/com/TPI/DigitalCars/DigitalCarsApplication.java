package com.TPI.DigitalCars;

import com.TPI.DigitalCars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalCarsApplication {

	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(DigitalCarsApplication.class, args);
	}

}
