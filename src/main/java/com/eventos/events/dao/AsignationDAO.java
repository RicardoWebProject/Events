package com.eventos.events.dao;

import com.eventos.events.entities.AsignarLocalidad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignationDAO extends JpaRepository<AsignarLocalidad, Integer> {
    
}
