package com.proyecto.prueba.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.prueba.entity.Actividad;
import com.proyecto.prueba.entity.TipoDocumento;
import com.proyecto.prueba.entity.Usuario;

public interface TipoDocumentoRepositorio extends JpaRepository<TipoDocumento, Long>{

}
