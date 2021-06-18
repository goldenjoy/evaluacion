package com.prueba.p.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.prueba.p.service.CrudSimple;

public abstract class Crud<T, ID>{

	private CrudSimple<T, ID> crud;
	
	@Autowired
	public Crud(CrudSimple<T, ID> servicio) {
		this.crud = servicio;
	}
	
    @GetMapping
    public List<T> mostrarTodos() {
    	return crud.obtenerTodos();
    }

    @SuppressWarnings("unchecked")
	@GetMapping("/{id}")
    public ResponseEntity<T> mostrarPorId(@PathVariable ID id) {
    	Optional<T> entity = crud.obtenerPorId(id);
    	HttpStatus estatus = null;
    	if(entity != null) {
    		estatus = HttpStatus.OK;
    	} else {
    		estatus = HttpStatus.NO_CONTENT;
    	}
    	
        return (ResponseEntity<T>) ResponseEntity.status(estatus).body(entity);
    }

    @SuppressWarnings("unchecked")
	@PostMapping
    public T guardar(@Valid @RequestBody T body) {
    	return (T) ResponseEntity.status(HttpStatus.CREATED).body(this.crud.guardar(body));
    }

    @PutMapping
    public T actualizar(@Valid @RequestBody T body) {
    	return this.crud.actualizar(body);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable ID id) {
    	this.crud.eliminarPorId(id);
    }

}
