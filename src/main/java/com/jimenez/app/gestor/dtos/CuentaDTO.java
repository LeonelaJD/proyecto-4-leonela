package com.jimenez.app.gestor.dtos;

import com.jimenez.app.gestor.enums.TipoCuentas;

public class CuentaDTO {
	
	private Long id;
	private String nombre;
	private TipoCuentas tipoCuenta;
	private Double saldo;
	
	public CuentaDTO() {
	}

	public CuentaDTO(Long id, String nombre, TipoCuentas tipoCuenta, Double saldo) {
		this.id = id;
		this.nombre = nombre;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
	}

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
