package com.jimenez.app.gestor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jimenez.app.gestor.dao.IGastosDao;
import com.jimenez.app.gestor.dtos.GastoDTO;
import com.jimenez.app.gestor.models.Categoria;
import com.jimenez.app.gestor.models.Cuenta;
import com.jimenez.app.gestor.models.Gasto;

@Component
public class GastosService implements IService<Gasto, GastoDTO>{
	
	//atributos
	@Autowired
	private IGastosDao gastosDao;

	@Override
	public List<Gasto> listar() {
		// TODO Auto-generated method stub
		List<Gasto> gastos = new ArrayList();
		gastos = (List<Gasto>) gastosDao.findAll();
		return gastos;
		
	}

	@Override
	public Optional<Gasto> getById(Long id) {
		// TODO Auto-generated method stubgastos
		Optional<Gasto> gasto = gastosDao.findById(id);
		return gasto;
		
	}

	@Override
	public void guardar(GastoDTO gastoDto) {
		// TODO Auto-generated method stub
		this.gastosDao.save(convertirDTOaGasto(gastoDto));
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.gastosDao.deleteById(id);
		
	}
	
	//metodo que permite convertir el DTO al modelo original
	public Gasto convertirDTOaGasto(GastoDTO gastoDto) {
		Gasto gasto = new Gasto();
		gasto.setId(gastoDto.getId());
		gasto.setCategoria(gastoDto.getCategoria());
		gasto.setCuenta(gastoDto.getCuenta());
		gasto.setMonto(gastoDto.getMonto());
		gasto.setFecha(gastoDto.getFecha());
		gasto.setConcepto(gastoDto.getConcepto());
		return gasto;
	}
}
