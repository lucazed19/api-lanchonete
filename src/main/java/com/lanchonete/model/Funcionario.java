package com.lanchonete.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nome_funcionario")
	private String nome;
	
	//criar as chaves estrangeiras se for necessário (pedido)
	

}
