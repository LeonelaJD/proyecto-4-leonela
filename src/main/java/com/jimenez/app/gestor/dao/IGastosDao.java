package com.jimenez.app.gestor.dao;

import org.springframework.data.repository.CrudRepository;

import com.jimenez.app.gestor.models.Gasto;

public interface IGastosDao extends CrudRepository<Gasto, Long>{

}
