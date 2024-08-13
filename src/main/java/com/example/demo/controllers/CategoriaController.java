package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CategoriaDto;
import com.example.demo.entities.Categoria;
import com.example.demo.repositories.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@PostMapping
	public String post(@RequestBody @Valid CategoriaDto dto) throws Exception {

		Categoria categoria = new Categoria();
		categoria.setNome(dto.getNome());

		CategoriaRepository categoriaRepository = new CategoriaRepository();
		categoriaRepository.insert(categoria);

		return "Categoria cadastrada com sucesso!";
	}

	@PutMapping("{id}")
	public String put(@PathVariable Integer id, @RequestBody @Valid CategoriaDto dto) throws Exception {

		CategoriaRepository categoriaRepository = new CategoriaRepository();
		Categoria categoria = categoriaRepository.findById(id);

		if (categoria == null)
			return "Categoria não encontrada, verifique o ID informado.";

		categoria.setNome(dto.getNome());
		categoriaRepository.update(categoria);

		return "Categoria atualizada com sucesso.";
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) throws Exception {

		CategoriaRepository categoriaRepository = new CategoriaRepository();
		Categoria categoria = categoriaRepository.findById(id);

		if (categoria == null)
			return "Categoria não encontrada, verifique o ID informado.";

		categoriaRepository.delete(id);

		return "Categoria excluída com sucesso!";
	}

	@GetMapping
	public List<Categoria> getAll() throws Exception {

		CategoriaRepository categoriaRepository = new CategoriaRepository();
		List<Categoria> lista = categoriaRepository.findAll();

		return lista;
	}

	@GetMapping("{id}")
	public Categoria getById(@PathVariable Integer id) throws Exception {
		
		CategoriaRepository categoriaRepository = new CategoriaRepository();
		Categoria categoria = categoriaRepository.findById(id);
		
		return categoria;
	}
}
