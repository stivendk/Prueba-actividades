package com.proyecto.prueba.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "n_documento")
	private String n_documento;
	@Column(name = "primer_nombre")
	private String primerNombre;
	@Column(name = "segundo_nombre")
	private String segundoNombre;
	@Column(name = "primer_apellido")
	private String primerApellido;
	@Column(name = "segundo_apellido")
	private String segundoApellido;
	@Column(name = "edad")
	private int edad;

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="tipo_documento", nullable=false) 
	private TipoDocumento tipoDocumento;
	
//	public Usuario() {
//		
//	}
//
//	public Usuario(String n_documento, String primerNombre, String segundoNombre, String primerApellido,
//			String segundoApellido, int edad, TipoDocumento tipoDocumento) {
//		super();
//		this.n_documento = n_documento;
//		this.primerNombre = primerNombre;
//		this.segundoNombre = segundoNombre;
//		this.primerApellido = primerApellido;
//		this.segundoApellido = segundoApellido;
//		this.edad = edad;
//		this.tipoDocumento = tipoDocumento;
//	}
//
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getN_documento() {
//		return n_documento;
//	}
//
//	public void setN_documento(String n_documento) {
//		this.n_documento = n_documento;
//	}
//
//	public String getPrimerNombre() {
//		return primerNombre;
//	}
//
//	public void setPrimerNombre(String primerNombre) {
//		this.primerNombre = primerNombre;
//	}
//
//	public String getSegundoNombre() {
//		return segundoNombre;
//	}
//
//	public void setSegundoNombre(String segundoNombre) {
//		this.segundoNombre = segundoNombre;
//	}
//
//	public String getPrimerApellido() {
//		return primerApellido;
//	}
//
//	public void setPrimerApellido(String primerApellido) {
//		this.primerApellido = primerApellido;
//	}
//
//	public String getSegundoApellido() {
//		return segundoApellido;
//	}
//
//	public void setSegundoApellido(String segundoApellido) {
//		this.segundoApellido = segundoApellido;
//	}
//
//	public int getEdad() {
//		return edad;
//	}
//
//	public void setEdad(int edad) {
//		this.edad = edad;
//	}
//
//	public TipoDocumento getTipoDocumento() {
//		return tipoDocumento;
//	}
//
//	public void setTipoDocumento(TipoDocumento tipoDocumento) {
//		this.tipoDocumento = tipoDocumento;
//	}

}
