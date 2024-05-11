package com.jimenez.app.gestor.dao;

import org.springframework.data.repository.CrudRepository;

import com.jimenez.app.gestor.models.Categoria;

public interface ICategoriasDao extends CrudRepository<Categoria, Long>{

}
