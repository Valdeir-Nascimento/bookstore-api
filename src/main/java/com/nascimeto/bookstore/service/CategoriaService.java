package com.nascimeto.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nascimeto.bookstore.domain.Categoria;
import com.nascimeto.bookstore.dto.CategoriaDTO;
import com.nascimeto.bookstore.repository.CategoriaRepository;
import com.nascimeto.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        return categoria.orElseThrow(() -> new ObjectNotFoundException(
                "Categoria não encontrada! Id: " + id + ", Tipo: " + Categoria.class.getName()));

    }

    public List<CategoriaDTO> findAll() {
        List<Categoria> categoriaList = categoriaRepository.findAll();
        return categoriaList.stream().map(CategoriaDTO::new).collect(Collectors.toList());
    }

    public Categoria create(Categoria categoria) {
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Long id, CategoriaDTO dto) {
        Categoria categoria = findById(id);
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());
        return categoriaRepository.save(categoria);
    }

    public void delete(Long categoriaId) {
        findById(categoriaId);
        try {
            categoriaRepository.deleteById(categoriaId);
        } catch (DataIntegrityViolationException e) {
            throw new com.nascimeto.bookstore.service.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada possui livros associados");
        }
    }
}
