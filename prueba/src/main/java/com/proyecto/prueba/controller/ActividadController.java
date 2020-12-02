package com.proyecto.prueba.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
//	@GetMapping("/actividades/{id}")
	@RequestMapping(value = "/actividades/{id}", method = RequestMethod.GET)
	public ResponseEntity<Actividad> capturarActividadId(@PathVariable("id") Long id) {
		Actividad actividad = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontro la actividad con el id: " + id));
		return ResponseEntity.ok(actividad);
	}
	
	//Metodo para editar actividad
//	@PutMapping("/actividades/{id}")
	@RequestMapping(value = "/actividades/{id}")
	public ResponseEntity<Actividad> updateActividad(@PathVariable("id") Long id, @RequestBody Actividad actividadDetails){
		Actividad actividad = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontro la actividad con el id: " + id));
		
		actividad.setTitulo(actividadDetails.getTitulo());
		actividad.setDescripcion(actividadDetails.getDescripcion());
		actividad.setHoraInicio(actividadDetails.getHoraInicio());
		actividad.setHoraFinal(actividadDetails.getHoraFinal());
		actividad.setEstado(actividadDetails.getEstado());
		actividad.setIdUsuario(actividadDetails.getIdUsuario());
		
		Actividad actividadUpd = repositorio.save(actividad);
		return ResponseEntity.ok(actividadUpd);
	}
	
	//Metodo para eliminar actividad
	@DeleteMapping("/actividades/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarActividad(@PathVariable("id") Long id){
		Actividad actividad = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontro la actividad con el id: " + id));
		
		repositorio.delete(actividad);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
