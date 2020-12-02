package com.proyecto.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.prueba.entity.Actividad;
import com.proyecto.prueba.entity.Usuario;
import com.proyecto.prueba.repository.ActividadRepository;
import com.proyecto.prueba.repository.UsuarioRepositorio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/api/v1/" })
public class UsuarioController {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	// Metodo para listar todas las actividades
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	// Metodo para crear usuarios-
	@PostMapping("/usuarios")
	public Usuario crearUsuario(@RequestBody Usuario u) {
		return usuarioRepositorio.save(u);
	}
}
