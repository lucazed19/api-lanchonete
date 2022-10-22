package com.lanchonete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome_produto")
	private String nomeProduto;
	
	@Column(name = "quantidade")
	private long quantidade;
	
	@Column(name = "valor")
	private double valor;
	
	@Enumerated(EnumType.STRING)
	private TipoProduto tipo;
	
	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}
	
	public Produto() {}
	
	public Produto(String nomeProduto, long quantidade, double valor, TipoProduto tipo) {
		super();
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.tipo = tipo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoProduto getTipo() {
		return tipo;
	}
	
	
}
