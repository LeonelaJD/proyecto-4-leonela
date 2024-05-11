package com.jimenez.app.gestor.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name = "categorias")
@Entity
public class Categoria {
	//Atributos -> variables -> Caracteristicas
	//2
	@Column(name = "id")
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ1")
	@SequenceGenerator(sequenceName = "customer_seq1", allocationSize = 1, name = "CUST_SEQ1")
	private Long id;
	
	//2
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "tipo")
	private String tipo;

	public Categoria() {
	}

	public Categoria(Long id, String nombre, String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	//Gets and sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoCuenta() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}

