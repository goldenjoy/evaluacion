package com.prueba.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.p.model.Articulo;
import com.prueba.p.service.ArticuloService;

@RestController
@RequestMapping("/service/articulo")
public class CrudRestController extends Crud<Articulo, String> {

	@Autowired
	public CrudRestController(ArticuloService service) {
		super(service);
	}
	
}
