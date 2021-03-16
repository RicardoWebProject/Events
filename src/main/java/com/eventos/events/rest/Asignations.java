package com.eventos.events.rest;

import java.util.List;

import com.eventos.events.dao.AsignationDAO;
import com.eventos.events.entities.AsignarLocalidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("asignarLocalidad")
public class Asignations {
    @Autowired
    private AsignationDAO asignationsDAO;

    //Mostrar asignaciones
    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public ResponseEntity<List<AsignarLocalidad>> getAsignacion(){
        List<AsignarLocalidad> asignaciones = asignationsDAO.findAll();
        return ResponseEntity.ok(asignaciones);
    }

    //Crear Asignaciones
    @PostMapping(value = "crear")
    public ResponseEntity<AsignarLocalidad> crearAsignacion(@RequestBody AsignarLocalidad asignacion){
        AsignarLocalidad nuevaAsignacion = asignationsDAO.save(asignacion);
        return ResponseEntity.ok(nuevaAsignacion);
    }
}
