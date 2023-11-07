package com.TPI.DigitalCars.model.security;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class AppUsuario implements UserDetails {
    //acale podemos decir si solo es unico ect
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private AppUsuarioRol appUsuarioRol;

    private boolean reserva;

    public AppUsuario(String nombre, String apellido, String email, String password, AppUsuarioRol appUsuarioRol, boolean reserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.appUsuarioRol = appUsuarioRol;
        this.reserva=reserva;
    }

    public AppUsuario() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new  SimpleGrantedAuthority(appUsuarioRol.name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

