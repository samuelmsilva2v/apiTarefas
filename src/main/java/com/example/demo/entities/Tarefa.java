package com.example.demo.entities;

import java.util.Date;

public class Tarefa {

	private Integer id;
	private String nome;
	private Date data;
	private String descricao;
	private Categoria categoria;

	public Tarefa() {
		// TODO Auto-generated constructor stub
	}

	public Tarefa(Integer id, String nome, Date data, String descricao, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.descricao = descricao;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", nome=" + nome + ", data=" + data + ", descricao=" + descricao + ", categoria="
				+ categoria + "]";
	}

}
