package com.lanchonete.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="valor_total", nullable=false)
	private double valorTotal;
	
	@ManyToMany(targetEntity = Bebida.class, cascade = CascadeType.ALL)
	private List<Bebida> bebida;
	
	@ManyToMany(targetEntity = Doce.class, cascade = CascadeType.ALL)
	private List<Doce> doce;
	
	@ManyToMany (targetEntity = Salgado.class, cascade = CascadeType.ALL)
	private List<Salgado> salgado;
	
	@OneToMany (targetEntity = Funcionario.class, cascade = CascadeType.ALL)
	private Funcionario funcionario;
	
	//Fiz alterações nas notations, de acordo com o modelo conceitual do banco

}
