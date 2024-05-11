package com.jimenez.app.gestor.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jimenez.app.gestor.dtos.CategoriaDTO;
import com.jimenez.app.gestor.dtos.CuentaDTO;
import com.jimenez.app.gestor.dtos.GastoDTO;
import com.jimenez.app.gestor.models.Categoria;
import com.jimenez.app.gestor.models.Cuenta;
import com.jimenez.app.gestor.models.Gasto;
import com.jimenez.app.gestor.services.IService;

@RestController
@RequestMapping ("/api/gastos") 
@CrossOrigin(origins = "*") //es para solucionar por mientras 
public class GastosController {

	@Autowired
	IService<Gasto, GastoDTO> gastosService;
	@Autowired
	IService<Categoria, CategoriaDTO> categoriasService;
	@Autowired
	IService<Cuenta, CuentaDTO> cuentasService;
	  
	@PostMapping
	public Map<String, String> guardar( @RequestBody GastoDTO gastoDto){
		Optional<Categoria> categoriaOptional = categoriasService.getById(gastoDto.getCategoria().getId());
		Categoria categoria;
		if (categoriaOptional.isPresent()) {
			categoria = categoriaOptional.get();
		} else {
			return null;
		}
		Optional<Cuenta> cuentaOptional = cuentasService.getById(gastoDto.getCuenta().getId());
		Cuenta cuenta;
		if (cuentaOptional.isPresent()) {
			cuenta = cuentaOptional.get();
		} else {
			return null;
		}
		gastoDto.setCategoria(categoria);
		gastoDto.setCuenta(cuenta);
		gastosService.guardar(gastoDto);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Gasto guardado correctamente");
		return respuesta;
  
}
	
	@GetMapping
	public List<Gasto> listar(){
		return gastosService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Gasto obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Gasto> gasto = gastosService.getById(id);
		if(gasto.isPresent()) {
			return gasto.get();
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "D") Long id){
		gastosService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Gasto eliminado correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody GastoDTO gastoDto,
			@PathVariable (name = "id") Long id)
	{
		Optional<Categoria> categoriaOptional = categoriasService.getById(gastoDto.getCategoria().getId());
		Categoria categoria;
		if (categoriaOptional.isPresent()) {
			categoria = categoriaOptional.get();
		} else {
			return null;
		}
		Optional<Cuenta> cuentaOptional = cuentasService.getById(gastoDto.getCuenta().getId());
		Cuenta cuenta;
		if (cuentaOptional.isPresent()) {
			cuenta = cuentaOptional.get();
		} else {
			return null;
		}
		gastoDto.setCategoria(categoria);
		gastoDto.setCuenta(cuenta);
		Optional<Gasto> gasto = gastosService.getById(id);
		if(gasto.isPresent()) {
			gastoDto.setId(id);  
			gastosService.guardar(gastoDto);
		}
		else {
			throw new RuntimeException("El gasto no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Gasto actualizado correctamente");
		return respuesta;
	} 
	
}
