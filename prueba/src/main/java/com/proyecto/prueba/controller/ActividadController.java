package com.proyecto.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.prueba.entity.Actividad;
import com.proyecto.prueba.exception.ResourceNotFoundException;
import com.proyecto.prueba.repository.ActividadRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/api/v1/" })
public class ActividadController {

	@Autowired
	ActividadRepository repositorio;

	// Metodo para listar todas las actividades
	@GetMapping("/actividades")
	public List<Actividad> listar() {
		return repositorio.findAll();
	}

	// Metodo para crear actividades
	@PostMapping("/actividades")
	public Actividad crearActividad(@RequestBody Actividad a) {
		return repositorio.save(a);
	}

	// Metodo para capturar por id
	@GetMapping("/actividades/{id}")
	public ResponseEntity<Actividad> capturarActividadId(Long id) {
		Actividad actividad = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontro la actividad con el i: " + id));
		return ResponseEntity.ok(actividad);
	}
	
	//Metodo para editar actividad
	
}
