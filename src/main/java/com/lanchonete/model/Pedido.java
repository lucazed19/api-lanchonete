package com.lanchonete.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="valor_total", nullable=false)
	@NumberFormat(style = Style.CURRENCY,pattern = "#.###,##")
	private double valorTotal;
	
	@Column(name="bebidas")
    @ElementCollection(targetClass=String.class)
	private List<String> bebidas;
	
	@Column(name="doces")
    @ElementCollection(targetClass=String.class)
	private List<String> doces;
	
	@Column(name="salgados")
    @ElementCollection(targetClass=String.class)
	private List<String> salgados;
	
	private String funcionario;
	
	public Pedido() {}

	public Pedido(double valorTotal, List<String> bebidas, List<String> doces, List<String> salgados, String funcionario) {
		super();
		this.valorTotal = valorTotal;
		this.bebidas = bebidas;
		this.doces = doces;
		this.salgados = salgados;
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

	public List<String> getBebida() {
		return bebidas;
	}

	public void setBebida(List<String> bebida) {
		this.bebidas = bebida;
	}

	public List<String> getDoce() {
		return doces;
	}

	public void setDoce(List<String> doce) {
		this.doces = doce;
	}

	public List<String> getSalgado() {
		return salgados;
	}

	public void setSalgado(List<String> salgado) {
		this.salgados = salgado;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}	
}
