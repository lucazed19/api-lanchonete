package com.lanchonete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doces")
public class Doce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome_doce")
	private String nomeDoce;
	
	@Column(name="valor")
	private double valor;
	
	public Doce() {}

	public Doce(String nomeDoce, double valor) {
		super();
		this.nomeDoce = nomeDoce;
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeDoce() {
		return nomeDoce;
	}

	public void setNomeDoce(String nomeDoce) {
		this.nomeDoce = nomeDoce;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
}
