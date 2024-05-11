package com.jimenez.app.gestor.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name= "gastos")
@Entity
public class Gasto {
	//Atributos -> variables -> Caracteristicas
	//2
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ3")
	@SequenceGenerator(sequenceName = "customer_seq3", allocationSize = 1, name = "CUST_SEQ3")
	private Long id;
	
	//3
	@JoinColumn(name = "categoria_id")
	@ManyToOne
	private Categoria categoria;

	//3
	@JoinColumn(name = "cuenta_id")
	@OneToOne
	private Cuenta cuenta;	
	
	//2
	@Column(name = "monto")
	private Double monto; 
		 
	//2
	@Column(name = "fecha")
	private Date fecha; //importar de java util
	
	//2
	@Column(name = "concepto")
	private String concepto;

	public Gasto() {
	}

	public Gasto(Long id, Categoria categoria, Cuenta cuenta, Double monto, Date fecha, String concepto) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.cuenta = cuenta;
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
