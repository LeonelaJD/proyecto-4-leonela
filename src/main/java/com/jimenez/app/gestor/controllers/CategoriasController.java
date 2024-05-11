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
import com.jimenez.app.gestor.models.Categoria;
import com.jimenez.app.gestor.services.IService;

@RestController
@RequestMapping ("/api/categorias") 
@CrossOrigin(origins = "*") //es para solucionar por mientras 
public class CategoriasController {

	@Autowired
	IService<Categoria, CategoriaDTO> categoriasService;
	
	@PostMapping
	public Map<String, String> guardar( @RequestBody CategoriaDTO categoriaDto){
		categoriasService.guardar(categoriaDto);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Categoria guardado correctamente");
		return respuesta;
   
	}
	
	@GetMapping
	public List<Categoria> listar(){
		return categoriasService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Categoria obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Categoria> categoria = categoriasService.getById(id);
		if(categoria.isPresent()) {
			return categoria.get();
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "D") Long id){
		categoriasService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Categoria eliminado correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody CategoriaDTO categoriaDto,
			@PathVariable (name = "id") Long id)
	{
		Optional<Categoria> categoria = categoriasService.getById(id);
		if(categoria.isPresent()) {
			categoriaDto.setId(id);  
			categoriasService.guardar(categoriaDto);
		}
		else {
			throw new RuntimeException("La Categoria no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Categoria actualizado correctamente");
		return respuesta;
	} 
	
	
}
