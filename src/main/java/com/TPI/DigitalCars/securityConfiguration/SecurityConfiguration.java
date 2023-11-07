package com.TPI.DigitalCars.securityConfiguration;

import com.TPI.DigitalCars.service.security.AppUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
    @Autowired
    private AppUsuarioService appUsuarioService;
    // cifrador para encriptar
    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;


    protected void SecurityFilterChain(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic()
                .and()
                .build();



    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bcryptPasswordEncoder);
        provider.setUserDetailsService(appUsuarioService);
        return provider;
    }


}
