package com.javacrud.model;

public class Destino {
	
	private int id;
	private String nomeDestino;
	private String descricao;
	private int dias;
	private int preco;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeDestino() {
		return nomeDestino;
	}
	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	
	@Override
	public String toString() {
		return "Destino [id=" + id + ", nomeDestino=" + nomeDestino + ", dias=" + dias + ", descricao=" + descricao
				+ ", preco=" + preco + "]";
	}
	
	
	
	

}
