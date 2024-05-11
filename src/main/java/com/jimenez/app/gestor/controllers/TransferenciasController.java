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
import com.jimenez.app.gestor.dtos.TransferenciaDTO;
import com.jimenez.app.gestor.models.Cuenta;
import com.jimenez.app.gestor.models.Transferencia;
import com.jimenez.app.gestor.services.IService;
 
@RestController
@RequestMapping ("/api/transferencias") 
@CrossOrigin(origins = "*") //es para solucionar por mientras 
public class TransferenciasController {
	
	//atributos
	//ClientesService cs; <--- esto seria sin inversion de dependencias (no utilizar interfaces)
	@Autowired
	IService<Transferencia, TransferenciaDTO> transferenciasService;
	@Autowired
	IService<Cuenta, CuentaDTO> cuentasService;
	
	/* public ClientesController(ClientesServiceNuevo cs) {
	// TODO Auto-generated constructor stub
	//this.cs = new ClientesService(); <-- esto seria sin inyeccion de dependencia 
	clientesService = cs;
	} */

	@PostMapping
	public Map<String, String> guardar( @RequestBody TransferenciaDTO transferenciaDto){
		Optional<Cuenta> cuentaOrigenOptional = cuentasService.getById(transferenciaDto.getCuentaOrigen().getId());
		Cuenta cuentaOrigen;
		if (cuentaOrigenOptional.isPresent()) {
			cuentaOrigen = cuentaOrigenOptional.get();
		} else {
			return null;
		}
		transferenciaDto.setCuentaOrigen(cuentaOrigen);
		Optional<Cuenta> cuentaDestinoOptional = cuentasService.getById(transferenciaDto.getCuentaDestino().getId());
		Cuenta cuentaDestino;
		if (cuentaDestinoOptional.isPresent()) {
			cuentaDestino = cuentaDestinoOptional.get();
		} else {
			return null;
		}
		transferenciaDto.setCuentaDestino(cuentaDestino);
		transferenciasService.guardar(transferenciaDto);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Transfecia guardado correctamente");
		return respuesta;
  
	}
	
	@GetMapping
	public List<Transferencia> listar(){
		return transferenciasService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Transferencia obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Transferencia> transferencia = transferenciasService.getById(id);
		if(transferencia.isPresent()) {
			return transferencia.get();
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "D") Long id){
		transferenciasService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Transferencia eliminado correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody TransferenciaDTO transferenciaDto,
			@PathVariable (name = "id") Long id)
	{
		Optional<Transferencia> transferencia = transferenciasService.getById(id);
		if(transferencia.isPresent()) {
			transferenciaDto.setId(id);  
			transferenciasService.guardar(transferenciaDto);
		}
		else {
			throw new RuntimeException("La Transferencia no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Transferencia actualizada correctamente");
		return respuesta;
	} 
	
	
}
