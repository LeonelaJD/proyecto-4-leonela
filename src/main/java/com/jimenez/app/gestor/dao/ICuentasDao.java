package com.jimenez.app.gestor.dao;

import org.springframework.data.repository.CrudRepository;

import com.jimenez.app.gestor.models.Cuenta;

public interface ICuentasDao extends CrudRepository<Cuenta, Long>{

}
