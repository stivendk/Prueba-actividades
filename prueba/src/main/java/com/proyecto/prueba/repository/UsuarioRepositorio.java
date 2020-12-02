package com.proyecto.prueba.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.prueba.entity.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}
