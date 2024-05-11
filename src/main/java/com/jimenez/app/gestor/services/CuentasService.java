package com.jimenez.app.gestor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jimenez.app.gestor.dao.ICuentasDao;
import com.jimenez.app.gestor.dtos.CategoriaDTO;
import com.jimenez.app.gestor.dtos.CuentaDTO;
import com.jimenez.app.gestor.models.Categoria;
import com.jimenez.app.gestor.models.Cuenta;

@Component
public class CuentasService implements IService<Cuenta, CuentaDTO>{
	
	//atributos
	@Autowired
	private ICuentasDao cuentasDao;
	
	
	@Override
	public List<Cuenta> listar() {
		// TODO Auto-generated method stub
		List<Cuenta> cuentas = new ArrayList();
		cuentas = (List<Cuenta>) cuentasDao.findAll();
		return cuentas;
		
	}

	@Override
	public Optional<Cuenta> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Cuenta> cuenta = cuentasDao.findById(id);
		return cuenta;
		
	}

	@Override
	public void guardar(CuentaDTO cuentaDto) {
		// TODO Auto-generated method stub
		this.cuentasDao.save(convertirDTOaCuenta(cuentaDto));
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.cuentasDao.deleteById(id);
		
	}

	//metodo que permite convertir el DTO al modelo original
	public Cuenta convertirDTOaCuenta(CuentaDTO cuentaDto) {
		Cuenta cuenta = new Cuenta();
		cuenta.setId(cuentaDto.getId());
		cuenta.setNombre(cuentaDto.getNombre());
		cuenta.setTipoCuenta(cuentaDto.getTipoCuenta());
		cuenta.setSaldo(cuentaDto.getSaldo());
		return cuenta;
	} 
}
