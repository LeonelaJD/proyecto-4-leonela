package com.jimenez.app.gestor.dao;

import org.springframework.data.repository.CrudRepository;

import com.jimenez.app.gestor.models.Ingreso;

public interface IIngresosDao extends CrudRepository<Ingreso, Long>{

}
