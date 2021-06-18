package com.prueba.p.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.prueba.p.model.Articulo;
import com.prueba.p.repository.CrudDao;

@Service
public class ArticuloService implements CrudSimple<Articulo, String> {

	@Autowired
	private CrudDao dao;
	
	@Override
	public List<Articulo> obtenerTodos() {
		return dao.findAll();
	}

	@Override
	public Optional<Articulo> obtenerPorId(String id) {
		return dao.findById(id);
	}

	@Override
	public Articulo guardar(Articulo t) {
		if (!this.dao.existsById(t.getId()))
			 return this.dao.save(t);
       else
       	 throw new DuplicateKeyException("El articulo "+t.getNombre()+" ya esta registrado y no puede ser duplicado");
	}

	@Override
	public Articulo actualizar(Articulo t) {
		if (this.dao.existsById(t.getId()))
			 return this.dao.save(t);
		else
			throw new EntityNotFoundException("El articulo "+t.getNombre()+" no se puede actualizar por que no existe");
	}

	@Override
	public void eliminarPorId(String id) {
		if (this.dao.existsById(id))
			 this.dao.deleteById(id);
		else
			throw new EntityNotFoundException("El articulo con el ID: "+id+" no se puede eliminar por que no existe");
	}

}
