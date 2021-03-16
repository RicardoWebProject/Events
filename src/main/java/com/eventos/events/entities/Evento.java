package com.eventos.events.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entidad de Evento
@Entity
@Table(name="eventos")
public class Evento {
    @Id
    @Column (name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //id

    @Column (name = "nombre", nullable = false, length = 50)
    private String nombre; //nombre

    @Column (name = "lugar", nullable = false, length = 255)
    private String lugar; //lugar

    @Column (name = "fecha", nullable = false, length = 10)
    private String fecha; //fecha

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }

    public void setLugar(String lugar){
        this.lugar = lugar;
    }
    public String getLugar(){
        return this.lugar;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public String getFecha(){
        return this.fecha;
    }

}
