package com.lanchonete.produtosapi.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.lanchonete.produtosapi.model.enums.TipoBebida;

public class Bebida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nome_bebida")
	private String nome;

	@Column(name = "fornecedor")
	private String fornecedor;

	@Column(name = "marca")
	private String marca;
	/*
	 * Completar isso dps, com uma definição de coluna correta, e com um construtor que prepare os dados para inserção no banco sem erros de tipagem.
	 * @Column(name = "data_entrada", columnDefinition = "") private LocalDateTime
	 * dataEntrada = LocalDateTime.now();
	 */
	
	@Enumerated(EnumType.STRING) //Será que esses enums são realmente necessários?
	private TipoBebida tipoBebida;

	private void setTipoBebida(TipoBebida tipoBebida) {
		this.tipoBebida = tipoBebida;
	}

	// Getters And Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}	

	public TipoBebida getTipoBebida() { // n sei se isso ta certo
		return tipoBebida;
	}

}
