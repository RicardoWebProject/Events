package com.eventos.events.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Entidad para Asignar Localidad
@Entity
@Table(name = "asignarLocalidad")
public class AsignarLocalidad {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //id

    @ManyToOne
    private Localidad localidad;

    @OneToOne
    private Evento evento;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public void setLocalidad(Localidad localidad){
        this.localidad = localidad;
    }
    public Localidad getLocalidad(){
        return this.localidad;
    }

    public void setEvento(Evento evento){
        this.evento = evento;
    }
    public Evento getEvento(){
        return this.evento;
    }
}
