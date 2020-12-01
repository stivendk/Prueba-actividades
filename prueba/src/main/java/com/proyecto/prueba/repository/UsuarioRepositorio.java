package com.proyecto.prueba.repository;


import org.springframework.data.repository.CrudRepository;

import com.proyecto.prueba.entity.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{

}
