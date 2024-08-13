package com.example.demo.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TarefaDto {

	@Size(min = 6, max = 100, message = "O nome da tarefa deve ter de 6 a 100 caracteres.")
	@NotEmpty(message = "O nome da tarefa é obrigatório.")
	private String nome;

	@NotNull(message = "A data é obrigatória.")
	private Date data;

	@Size(min = 6, max = 250, message = "A descrição da tarefa deve ter de 6 a 250 caracteres.")
	@NotEmpty(message = "A descrição da tarefa é obrigatória.")
	private String descricao;

	@NotNull(message = "O ID da categoria da tarefa é obrigatório.")
	private Integer categoriaId;

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

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
}
