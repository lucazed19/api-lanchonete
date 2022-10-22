package com.lanchonete.produtosapi.model.enums;

public enum TipoProduto {
	BEBIDA("bebida"),
	COMIDA("comida");
	
	private String value;
	
	private TipoProduto(String value) {
		this.value = value;
	}
	
	public String getTipo() {
		return value;
	}
}
