package com.prueba.p.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.p.model.Articulo;

@Repository
public interface CrudDao extends JpaRepository<Articulo, String> {

}
