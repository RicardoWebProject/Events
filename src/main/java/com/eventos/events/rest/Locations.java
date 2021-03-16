package com.eventos.events.rest;

import java.util.List;
import java.util.Optional;

import com.eventos.events.dao.LocationsDAO;
import com.eventos.events.entities.Localidad;

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
@RequestMapping("localidad")
public class Locations {
    @Autowired
    private LocationsDAO locationsDAO;
    
    //Mostrar localidades
    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public ResponseEntity<List<Localidad>> getLocalidad(){
        List<Localidad> localidades = locationsDAO.findAll();
        return ResponseEntity.ok(localidades);
    }

    //Mostrar Localidad por ID
    @RequestMapping(value = "{localidadID}", method = RequestMethod.GET)
    public ResponseEntity<Localidad> getLocalidadById(@PathVariable("localidadId") int localidadId){
        Optional<Localidad> locationOptional = locationsDAO.findById(localidadId);
        if (locationOptional.isPresent()) {
            return ResponseEntity.ok(locationOptional.get());
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    //Crear Localidad
    @PostMapping(value = "crear")
    public ResponseEntity<Localidad> crearLocalidad(@RequestBody Localidad localidad){
        Localidad nuevaLocalidad = locationsDAO.save(localidad);
        return ResponseEntity.ok(nuevaLocalidad);
    }

    //Borrar Localidad
    @DeleteMapping(value = "eliminar/{localidadId}")
    public ResponseEntity<Void> eliminarLocalidad(@PathVariable("localidadId") int localidadId){
        locationsDAO.deleteById(localidadId);
        return ResponseEntity.ok(null);
    }

    //Actualizar localidad
    @PutMapping(value = "actualizar")
    public ResponseEntity<Localidad> actualizarLocalidad(@RequestBody Localidad localidad){
        Optional<Localidad> locationOptional = locationsDAO.findById(localidad.getId());
        if (locationOptional.isPresent()) {
            Localidad actualizarLocalidad = locationOptional.get();
            actualizarLocalidad.setNombre(localidad.getNombre());
            locationsDAO.save(actualizarLocalidad);
            return ResponseEntity.ok(actualizarLocalidad);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
