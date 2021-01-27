package com.nascimeto.bookstore.controllers;

import com.nascimeto.bookstore.domain.Livro;
import com.nascimeto.bookstore.dto.LivroDTO;
import com.nascimeto.bookstore.service.LivroService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{idLivro}")
    public ResponseEntity<Livro> findById(@PathVariable Long idLivro) {
        Livro livro = livroService.findById(idLivro);
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long idCategoria ) {
        List<Livro> livros = livroService.findAll(idCategoria);
        List<LivroDTO> dtoList  = livros.stream().map(LivroDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @PutMapping("/{idLivro}")
    public ResponseEntity<Livro> update(@PathVariable Long idLivro, @RequestBody Livro livro) {
        Livro livroAtualizado = livroService.update(idLivro, livro);
        return ResponseEntity.ok().body(livroAtualizado);
    }

    @PatchMapping("/{idLivro}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Long idLivro, @RequestBody Livro livro) {
        Livro livroAtualizado = livroService.update(idLivro, livro);
        return ResponseEntity.ok().body(livroAtualizado);
    }

}
