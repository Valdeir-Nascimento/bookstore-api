package com.nascimeto.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nascimeto.bookstore.domain.Categoria;
import com.nascimeto.bookstore.dto.CategoriaDTO;
import com.nascimeto.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping("/{categoriaId}")
	public ResponseEntity<Categoria> findById(@PathVariable Long categoriaId) {
		Categoria categoria = categoriaService.findById(categoriaId);
		return ResponseEntity.ok().body(categoria); 
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> categorias = categoriaService.findAll();
		return ResponseEntity.ok().body(categorias);
	}
	
}
