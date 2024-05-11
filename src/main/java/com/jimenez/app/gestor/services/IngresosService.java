package com.jimenez.app.gestor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jimenez.app.gestor.dao.IIngresosDao;
import com.jimenez.app.gestor.dtos.IngresoDTO;
import com.jimenez.app.gestor.models.Categoria;
import com.jimenez.app.gestor.models.Cuenta;
import com.jimenez.app.gestor.models.Ingreso;

@Component
public class IngresosService implements IService<Ingreso, IngresoDTO>{

	//atributos
	@Autowired
	private IIngresosDao ingresosDao;
	
	
	@Override
	public List<Ingreso> listar() {
		// TODO Auto-generated method stub
		List<Ingreso> ingresos = new ArrayList();
		ingresos = (List<Ingreso>) ingresosDao.findAll();
		return ingresos;
		
	}

	@Override
	public Optional<Ingreso> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Ingreso> ingreso = ingresosDao.findById(id);
		return ingreso;
		
	}

	@Override
	public void guardar(IngresoDTO ingresoDto) {
		// TODO Auto-generated method stub
		this.ingresosDao.save(convertirDTOaIngreso(ingresoDto));
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.ingresosDao.deleteById(id);
		
	}

	//metodo que permite convertir el DTO al modelo original
	public Ingreso convertirDTOaIngreso(IngresoDTO ingresoDto) {
		Ingreso ingreso = new Ingreso();
		ingreso.setId(ingresoDto.getId());
		ingreso.setCategoria(ingresoDto.getCategoria());
		ingreso.setCuenta(ingresoDto.getCuenta());
		ingreso.setMonto(ingresoDto.getMonto());
		ingreso.setFecha(ingresoDto.getFecha());
		ingreso.setConcepto(ingresoDto.getConcepto());
		return ingreso;
	}
}
