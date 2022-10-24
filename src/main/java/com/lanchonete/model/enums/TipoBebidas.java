package com.lanchonete.model.enums;

public enum TipoBebidas {

	AGUA("agua"), // AGUA("agua", null),
	REFRIGERANTE("refrigerante", true, true), SUCO("suco", false), VITAMINA("VITAMINA", false, true),
	ALCHOLICA("alcholica", true, true);

	private String value;
	private Boolean gas;
	private Boolean comprado;

	// Nesse tipo de situação não temos set, apenas contrutores mesmo
	private TipoBebidas(String value, Boolean gas, Boolean comprado) {
		this.value = value;
		this.gas = gas;
		this.comprado = comprado;
	}

	private TipoBebidas(String value, Boolean gas) {
		this.value = value;
		this.gas = gas;
	}

	private TipoBebidas(String value) { // o unico que pode não pode ser nulo é o value. Se esse campo fosse nulo no DB,
										// seria necessário criar um contrutor vazio
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public Boolean getGas() {
		return gas;
	}

	public Boolean getComprado() {
		return comprado;
	}
}