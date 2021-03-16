package com.eventos.events.dao;

import com.eventos.events.entities.Evento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsDAO extends JpaRepository<Evento, Integer> {
    
}
