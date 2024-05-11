package com.jimenez.app.gestor.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name = "transferencias")
@Entity
public class Transferencia {
	//Atributos -> variables -> Caracteristicas
	//2
	@Column(name = "id")
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ5")
	@SequenceGenerator(sequenceName = "customer_seq5", allocationSize = 1, name = "CUST_SEQ5")
	private Long id;
	
	//3
	@JoinColumn(name = "cuenta_origen_id")
	@ManyToOne
	private Cuenta cuentaOrigen;
	
	//3
	@JoinColumn(name = "cuenta_destino_id")
	@ManyToOne
	private Cuenta cuentaDestino;
	
	//2
	@Column(name = "monto")
	private Double monto;
	
	//2
	@Column(name = "fecha")
	private Date fecha; //importar de java util
	
	//2
	@Column(name = "concepto")
	private String concepto;

	public Transferencia() {
	}

	public Transferencia(Long id, Cuenta cuentaOrigen, Cuenta cuentaDestino, Double monto, Date fecha,
			String concepto) {
		super();
		this.id = id;
		this.cuentaOrigen = cuentaOrigen;
		this.cuentaDestino = cuentaDestino;
		this.monto = monto;
		this.fecha = fecha;
		this.concepto = concepto;
	}

	//Gets and sets
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
