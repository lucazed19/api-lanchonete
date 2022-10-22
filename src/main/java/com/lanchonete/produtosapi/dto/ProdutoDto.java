package com.lanchonete.produtosapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lanchonete.produtosapi.model.enums.TipoProduto;

public class ProdutoDto {
	
	@NotBlank
	private String nomeProduto;
	@NotNull
	private long quantidade;
	@NotNull
	private double valor;
	@NotNull
	private TipoProduto tipo;
	
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
	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
