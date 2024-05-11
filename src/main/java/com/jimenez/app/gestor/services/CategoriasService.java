package com.jimenez.app.gestor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jimenez.app.gestor.dao.ICategoriasDao;
import com.jimenez.app.gestor.dtos.CategoriaDTO;
import com.jimenez.app.gestor.models.Categoria;

@Component
public class CategoriasService implements IService<Categoria, CategoriaDTO>{
	
	//atributos
	@Autowired
	private ICategoriasDao categoriasDao;
	
	@Override
	public List<Categoria> listar() {
		// TODO Auto-generated method stub
		List<Categoria> categorias = new ArrayList();
		categorias = (List<Categoria>) categoriasDao.findAll();
		return categorias;
		
	}

	@Override
	public Optional<Categoria> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Categoria> categoria = categoriasDao.findById(id);
		return categoria;
		
	}
 
	@Override
	public void guardar(CategoriaDTO categoriaDto) {
		// TODO Auto-generated method stub
		this.categoriasDao.save(convertirDTOaCategoria(categoriaDto));
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.categoriasDao.deleteById(id);
		
	}

	//metodo que permite convertir el DTO al modelo original
	public Categoria convertirDTOaCategoria(CategoriaDTO categoriaDto) {
		Categoria categoria = new Categoria();
		categoria.setId(categoriaDto.getId());
		categoria.setNombre(categoriaDto.getNombre());
		categoria.setTipo(categoriaDto.getTipo());
		return categoria;
	} 
}
