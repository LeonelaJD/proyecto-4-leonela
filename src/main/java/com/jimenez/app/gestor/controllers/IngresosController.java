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
import com.jimenez.app.gestor.dtos.IngresoDTO;
import com.jimenez.app.gestor.models.Categoria;
import com.jimenez.app.gestor.models.Cuenta;
import com.jimenez.app.gestor.models.Ingreso;
import com.jimenez.app.gestor.services.IService;

@RestController
@RequestMapping ("/api/ingresos") 
@CrossOrigin(origins = "*") //es para solucionar por mientras 
public class IngresosController {

	//atributos
	//ClientesService cs; <--- esto seria sin inversion de dependencias (no utilizar interfaces)
	@Autowired
	IService<Ingreso, IngresoDTO> ingresosService;
	@Autowired
	IService<Categoria, CategoriaDTO> categoriasService;
	@Autowired
	IService<Cuenta, CuentaDTO> cuentasService;
		
	/*public ClientesController(ClientesServiceNuevo cs) {
	// TODO Auto-generated constructor stub
	//this.cs = new ClientesService(); <-- esto seria sin inyeccion de dependencia 
	clientesService = cs;
	}*/
	
	@PostMapping
	public Map<String, String> guardar( @RequestBody IngresoDTO ingresosDto){
		Optional<Categoria> categoriaOptional = categoriasService.getById(ingresosDto.getCategoria().getId());
		Categoria categoria;
		if (categoriaOptional.isPresent()) {
			categoria = categoriaOptional.get();
		} else {
			return null;
		}
		Optional<Cuenta> cuentaOptional = cuentasService.getById(ingresosDto.getCuenta().getId());
		Cuenta cuenta;
		if (cuentaOptional.isPresent()) {
			cuenta = cuentaOptional.get();
		} else {
			return null;
		}
		ingresosDto.setCategoria(categoria);
		ingresosDto.setCuenta(cuenta);
		ingresosService.guardar(ingresosDto);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Ingreso guardado correctamente");
		return respuesta;
  
	}
	
	@GetMapping
	public List<Ingreso> listar(){
		return ingresosService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Ingreso obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Ingreso> ingreso = ingresosService.getById(id);
		if(ingreso.isPresent()) {
			return ingreso.get();
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "D") Long id){
		ingresosService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Ingreso eliminado correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody IngresoDTO ingresoDto,
			@PathVariable (name = "id") Long id)
	{
		Optional<Categoria> categoriaOptional = categoriasService.getById(ingresoDto.getCategoria().getId());
		Categoria categoria;
		if (categoriaOptional.isPresent()) {
			categoria = categoriaOptional.get();
		} else {
			return null;
		}
		Optional<Cuenta> cuentaOptional = cuentasService.getById(ingresoDto.getCuenta().getId());
		Cuenta cuenta;
		if (cuentaOptional.isPresent()) {
			cuenta = cuentaOptional.get();
		} else {
			return null;
		}
		ingresoDto.setCategoria(categoria);
		ingresoDto.setCuenta(cuenta);
		Optional<Ingreso> ingreso = ingresosService.getById(id);
		if(ingreso.isPresent()) {
			ingresoDto.setId(id);  
			ingresosService.guardar(ingresoDto);
		}
		else {
			throw new RuntimeException("El Ingreso no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Ingreso actualizado correctamente");
		return respuesta;
	}
}
