package com.eventos.events.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entidad de Localidad
@Entity
@Table(name = "localidad")
public class Localidad {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //id localidad

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre; //Nombre localidad

    public void setId (int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public String getNombre (){
        return this.nombre;
    }

}
