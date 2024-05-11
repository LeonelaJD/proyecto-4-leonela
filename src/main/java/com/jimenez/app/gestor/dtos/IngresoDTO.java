package com.jimenez.app.gestor.dtos;

import java.util.Date;

import com.jimenez.app.gestor.models.Categoria;
import com.jimenez.app.gestor.models.Cuenta;

public class IngresoDTO {

	private Long id;
	private Categoria categoria;
	private Cuenta cuenta;
	private Double monto;
	private Date fecha;
	private String concepto;
	
	public IngresoDTO() {
	}

	public IngresoDTO(Long id, Categoria categoria, Cuenta cuenta, Double monto, Date fecha, String concepto) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.cuenta = cuenta;
		this.monto = monto;
		this.fecha = fecha;
		this.concepto = concepto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
}
