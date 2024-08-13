package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

	@PostMapping
	public void post() throws Exception {
		
	}
	
	@PutMapping
	public void put() throws Exception {
		
	}
	
	@DeleteMapping
	public void delete() throws Exception {
		
	}
	
	@GetMapping
	public void getAll() throws Exception {
		
	}
}
