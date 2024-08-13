package com.example.demo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.TarefaDto;
import com.example.demo.entities.Categoria;
import com.example.demo.entities.Tarefa;
import com.example.demo.repositories.TarefaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

	@PostMapping
	public String post(@RequestBody @Valid TarefaDto dto) throws Exception {

		Tarefa tarefa = new Tarefa();
		tarefa.setCategoria(new Categoria());

		tarefa.setNome(dto.getNome());
		tarefa.setData(dto.getData());
		tarefa.setDescricao(dto.getDescricao());
		tarefa.getCategoria().setId(dto.getCategoriaId());

		TarefaRepository tarefaRepository = new TarefaRepository();
		tarefaRepository.insert(tarefa);

		return "Tarefa cadastrada com sucesso!";
	}

	@PutMapping("{id}")
	public String put(@PathVariable Integer id, @RequestBody @Valid TarefaDto dto) throws Exception {

		TarefaRepository tarefaRepository = new TarefaRepository();
		Tarefa tarefa = tarefaRepository.findById(id);

		if (tarefa == null)
			return "Tarefa não encontrada, verifique o ID informado.";

		tarefa.setNome(dto.getNome());
		tarefa.setData(dto.getData());
		tarefa.setDescricao(dto.getDescricao());
		tarefa.getCategoria().setId(dto.getCategoriaId());
		tarefaRepository.update(tarefa);

		return "Tarefa atualizada com sucesso!";
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) throws Exception {

		TarefaRepository tarefaRepository = new TarefaRepository();
		Tarefa tarefa = tarefaRepository.findById(id);

		if (tarefa == null)
			return "Tarefa não encontrada, verifique o ID informado.";

		tarefaRepository.delete(id);

		return "Tarefa excluída com sucesso!";
	}

	@GetMapping("{dataMin}/{dataMax}")
	public List<Tarefa> getAll(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataMin, 
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataMax)
			throws Exception {

		TarefaRepository tarefaRepository = new TarefaRepository();
		List<Tarefa> lista = tarefaRepository.findAll(dataMin, dataMax);
		
		return lista;
	}
	
	@GetMapping("{id}")
	public Tarefa getById(@PathVariable Integer id) throws Exception {
		
		TarefaRepository tarefaRepository = new TarefaRepository();
		Tarefa tarefa = tarefaRepository.findById(id);
		
		return tarefa;
	}
}
