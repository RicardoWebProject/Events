package com.eventos.events.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Home {
    //Primera vista
    @GetMapping
    public String hello(){
        String mensaje = "Bienvenido a la API de Eventos.\n" 
        + "Puede utilizar Swagger para observar la documentación de este proyecto:\n"
        + "http://localhost:8080/v3/api-docs   ,\n"
        + "http://localhost:8080/swagger-ui/index.html"
        ;
        return mensaje;
    }
}
