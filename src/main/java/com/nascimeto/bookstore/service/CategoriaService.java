package com.nascimeto.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nascimeto.bookstore.domain.Categoria;
import com.nascimeto.bookstore.repositories.CategoriaRepository;
import com.nascimeto.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);

		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));

	}

	public List<Categoria> getAll() {
		return categoriaRepository.findAll();
	}

}
