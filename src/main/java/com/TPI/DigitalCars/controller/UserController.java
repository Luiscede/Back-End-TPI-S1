package com.TPI.DigitalCars.controller;


import com.TPI.DigitalCars.exceptions.ResourceNotFoundException;
import com.TPI.DigitalCars.model.security.AppUsuario;
import com.TPI.DigitalCars.repository.security.UserRepository;
import com.TPI.DigitalCars.service.security.AppUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    UserRepository userRepository;

    private AppUsuarioService appUsuarioService;


    @Autowired
    public UserController(AppUsuarioService appUsuarioService) {
        this.appUsuarioService = appUsuarioService;
    }

    //traer datos de usuario



    @GetMapping("/{id}")
    public ResponseEntity<AppUsuario> buscarUsuarioPorID (@PathVariable Long id)throws ResourceNotFoundException {
        Optional<AppUsuario> userBuscado = appUsuarioService.buscarUsuarioPorId(id);
        if(userBuscado.isPresent()){
            return ResponseEntity.ok(userBuscado.get());
        }else{
            throw new ResourceNotFoundException("No se encuentra id: "+id+" en la base de datos");
            //return ResponseEntity.notFound().build();
        }
    }

}
