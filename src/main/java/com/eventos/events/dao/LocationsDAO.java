package com.eventos.events.dao;

import com.eventos.events.entities.Localidad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsDAO extends JpaRepository<Localidad, Integer> {
    
}
