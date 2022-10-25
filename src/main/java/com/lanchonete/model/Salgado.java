package com.lanchonete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salgados")
public class Salgado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome_salgado")
	private String nomeSalgado;
	
	@Column(name="valor")
	private double valor;
	
	public Salgado() {}

	public Salgado(String nomeSalgado, double valor) {
		super();
		this.nomeSalgado = nomeSalgado;
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeSalgado() {
		return nomeSalgado;
	}

	public void setNomeSalgado(String nomeSalgado) {
		this.nomeSalgado = nomeSalgado;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
