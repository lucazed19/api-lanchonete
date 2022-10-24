package com.lanchonete.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.lanchonete.model.enums.TipoBebidas;
import com.lanchonete.model.enums.TipoSalgados;

public class Salgados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nome_salgado")
	private String nome;
	
	@Enumerated(EnumType.STRING) // Será que esses enums são realmente necessários?
	private TipoSalgados tipoSalgados;

	private void setTipoSalgados(TipoSalgados tipoSalgados) {
		this.tipoSalgados = tipoSalgados;
	}

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

	public TipoSalgados getTipoSalgados() {
		return tipoSalgados;
	}
	

	
		
	
}
