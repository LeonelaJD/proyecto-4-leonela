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

import com.jimenez.app.gestor.dtos.CuentaDTO;
import com.jimenez.app.gestor.models.Cuenta;
import com.jimenez.app.gestor.services.IService;

@RestController
@RequestMapping ("/api/cuentas") 
@CrossOrigin(origins = "*") //es para solucionar por mientras
public class CuentasController {
	
	@Autowired
	IService<Cuenta, CuentaDTO> cuentasService;

	@PostMapping
	public Map<String, String> guardar( @RequestBody CuentaDTO cuentaDto){
		cuentasService.guardar(cuentaDto);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Cuenta guardado correctamente");
		return respuesta;
  
	}
	
	@GetMapping
	public List<Cuenta> listar(){
		return cuentasService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Cuenta obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Cuenta> cuenta = cuentasService.getById(id);
		if(cuenta.isPresent()) {
			return cuenta.get();
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "D") Long id){
		cuentasService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Cuenta eliminado correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody CuentaDTO cuentaDto,
			@PathVariable (name = "id") Long id)
	{
		Optional<Cuenta> cuenta = cuentasService.getById(id);
		if(cuenta.isPresent()) {
			cuentaDto.setId(id);  
			cuentasService.guardar(cuentaDto);
		}
		else {
			throw new RuntimeException("La cuenta no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Cuenta actualizada correctamente");
		return respuesta;
	} 
	
}
