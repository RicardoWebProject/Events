package com.eventos.events.rest;
import java.util.List;
import java.util.Optional;

import com.eventos.events.dao.EventsDAO;
import com.eventos.events.entities.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("evento")
public class Events {

    @Autowired
    private EventsDAO eventsDAO;

    //Mostrar todos los eventos
    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public ResponseEntity<List<Evento>> getEvento(){
        List<Evento> eventos = eventsDAO.findAll();

        return ResponseEntity.ok(eventos);
    }

    //Mostrar Evento por ID
    @RequestMapping(value = "{eventoId}", method = RequestMethod.GET)
    public ResponseEntity<Evento> getEventoById(@PathVariable("eventoId") int eventoId) {
        Optional<Evento> eventOptional = eventsDAO.findById(eventoId);

        if (eventOptional.isPresent()) {
            return ResponseEntity.ok(eventOptional.get());
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }
    
    //Crear evento
    @PostMapping(value = "crear")
    public ResponseEntity<Evento> crearEvento(@RequestBody Evento evento) {
        Evento nuevoEvento = eventsDAO.save(evento);
        return ResponseEntity.ok(nuevoEvento);
    }
    
    //Borrar evento
    @DeleteMapping(value = "eliminar/{eventoId}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable("eventoId") int eventoId) {
        eventsDAO.deleteById(eventoId);
        return ResponseEntity.ok(null);
    }
    
    //Actualizar evento
    @PutMapping(value = "actualizar")
    public ResponseEntity<Evento> actualizarEvento(@RequestBody Evento evento){
        Optional<Evento> eventOptional = eventsDAO.findById(evento.getId());
    
        if (eventOptional.isPresent()) {
            Evento actualizarEvento = eventOptional.get();
            actualizarEvento.setNombre(evento.getNombre());
            actualizarEvento.setLugar(evento.getFecha());
            actualizarEvento.setFecha(evento.getFecha());
            eventsDAO.save(actualizarEvento);
            return ResponseEntity.ok(actualizarEvento);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
