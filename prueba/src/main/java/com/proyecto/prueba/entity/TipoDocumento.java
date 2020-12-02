package com.proyecto.prueba.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tipo_documento")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoDocumento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String tipoDocumento;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private List<Usuario> usuario;
	
	public TipoDocumento() {
	}
	
	public TipoDocumento(String tipoDocumento) {
		super();
		this.tipoDocumento = tipoDocumento;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
}
