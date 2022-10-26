package com.lanchonete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bebidas")
public class Bebida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome_bebida")
	private String nomeBebida;
	
	@Column(name="valor")
	private double valor;
	
	@Column(name="descricao")
	private String descricao;
	
	public Bebida() {}
	
	public Bebida(String nomeBebida, double valor, String descricao) {
		super();
		this.nomeBebida = nomeBebida;
		this.valor = valor;
		this.descricao = descricao;
	}
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeBebida() {
		return nomeBebida;
	}

	public void setNomeBebida(String nomeBebida) {
		this.nomeBebida = nomeBebida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
