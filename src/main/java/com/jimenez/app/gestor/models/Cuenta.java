package com.jimenez.app.gestor.models;

import com.jimenez.app.gestor.enums.TipoCuentas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name= "cuentas")
@Entity
public class Cuenta {
	//Atributos -> variables -> Caracteristicas
	//2
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ2")
	@SequenceGenerator(sequenceName = "customer_seq2", allocationSize = 1, name = "CUST_SEQ2")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	//2
	@Column(name = "tipo_cuenta")
	private TipoCuentas tipoCuenta;
	
	//2
	@Column(name = "saldo")
	private Double saldo;

	public Cuenta() {
	}

	public Cuenta(Long id, String nombre, TipoCuentas tipoCuenta, Double saldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
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

	public TipoCuentas getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuentas tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
