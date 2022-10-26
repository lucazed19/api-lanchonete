package com.lanchonete.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="descricao")
	private String descricao;
	
	@OneToMany(targetEntity = Bebida.class, cascade = CascadeType.ALL)
	private List<Bebida> bebida;
	
	@OneToMany(targetEntity = Doce.class, cascade = CascadeType.ALL)
	private List<Doce> doce;
	
	@OneToMany(targetEntity = Salgado.class, cascade = CascadeType.ALL)
	private List<Salgado> salgado;
	
	@OneToOne(targetEntity = Funcionario.class, cascade = CascadeType.ALL)
	private Funcionario funcionario;
	
	public Pedido() {}

	public Pedido(double valorTotal, String descricao, List<Bebida> bebida, List<Doce> doce, List<Salgado> salgado,
			Funcionario funcionario) {
		super();
		this.valorTotal = valorTotal;
		this.descricao = descricao;
		this.bebida = bebida;
		this.doce = doce;
		this.salgado = salgado;
		this.funcionario = funcionario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Bebida> getBebida() {
		return bebida;
	}

	public void setBebida(List<Bebida> bebida) {
		this.bebida = bebida;
	}

	public List<Doce> getDoce() {
		return doce;
	}

	public void setDoce(List<Doce> doce) {
		this.doce = doce;
	}

	public List<Salgado> getSalgado() {
		return salgado;
	}

	public void setSalgado(List<Salgado> salgado) {
		this.salgado = salgado;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	

}
