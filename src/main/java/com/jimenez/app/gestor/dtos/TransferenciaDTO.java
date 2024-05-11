package com.jimenez.app.gestor.dtos;

import java.util.Date;

import com.jimenez.app.gestor.models.Cuenta;

public class TransferenciaDTO {

	private Long id;
	private Cuenta cuentaOrigen;
	private Cuenta cuentaDestino;
	private Double monto;
	private Date fecha;
	private String concepto;
	
	public TransferenciaDTO() {
	}

	public TransferenciaDTO(Long id, Cuenta cuentaOrigen, Cuenta cuentaDestino, Double monto, Date fecha,
			String concepto) {
		super();
		this.id = id;
		this.cuentaOrigen = cuentaOrigen;
		this.cuentaDestino = cuentaDestino;
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

	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public Cuenta getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
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
