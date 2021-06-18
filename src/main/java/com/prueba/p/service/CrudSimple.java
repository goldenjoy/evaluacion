package com.prueba.p.service;

import java.util.List;
import java.util.Optional;

public interface CrudSimple<T, ID> {
	public List<T> obtenerTodos();
	public Optional<T> obtenerPorId(ID id);
	public T guardar(T t);
	public T actualizar(T t);
	public void eliminarPorId(ID id);
}