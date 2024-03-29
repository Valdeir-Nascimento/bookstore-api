package com.nascimeto.bookstore.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nascimeto.bookstore.domain.Categoria;
import com.nascimeto.bookstore.dto.CategoriaDTO;
import com.nascimeto.bookstore.service.CategoriaService;

import javax.validation.Valid;

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

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody @Valid Categoria categoria) {
        categoria = categoriaService.create(categoria);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();

        return ResponseEntity.created(uri).body(categoria);
    }

    @PutMapping(value = "/{categoriaId}")
    public ResponseEntity<CategoriaDTO> update(
            @PathVariable Long categoriaId, @RequestBody @Valid CategoriaDTO categoria) {
        Categoria categoriaAtualizada = categoriaService.update(categoriaId, categoria);
        return ResponseEntity.ok().body(new CategoriaDTO(categoriaAtualizada));
    }

    @DeleteMapping(value = "/{categoriaId}")
    public ResponseEntity<Void> delete(@PathVariable Long categoriaId) {
        categoriaService.delete(categoriaId);
        return ResponseEntity.noContent().build();
    }

}
