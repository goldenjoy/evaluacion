package com.prueba.p.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "articulo")
public class Articulo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5108114882351722617L;

	@Id
	@Column(updatable = false)
	@Size(min=10, max=10)
	private String id;
	
	@Column(updatable = false)
	@Size(min=0, max=20)
	private String nombre;
	
	@Size(min=0, max=200)
	private String descripcion;
	
	@Column(updatable = false)
	private double precio;
	
	@Size(min=10, max=10)
	private String modelo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDesc(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
